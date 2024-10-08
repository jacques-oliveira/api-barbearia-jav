package com.barbearia.api.service;

import com.barbearia.api.Repository.ProdutoRepository;
import com.barbearia.api.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService implements IProdutoService{

    @Autowired
    private final ProdutoRepository _produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository){
        this._produtoRepository = produtoRepository;
    }

    @Override
    public Produto findById(Long id) {
        Optional<Produto> produtoOptional = _produtoRepository.findById(id);
        Produto produto = produtoOptional.get();
        if(produtoOptional.isPresent()){

            return produto;
        }
        return null;
    }

    @Override
    public List<Produto> findAll() {
        List<Produto> produtos = _produtoRepository.findAll();
        return produtos;
    }

    @Override
    public Produto create(Produto produto) {
        Optional<Produto> produtoBd = _produtoRepository.findById(produto.getId());
        if (!produtoBd.isPresent()){
            _produtoRepository.save(produto);
            return produto;
        }
        return null;
    }
    @Override
    public boolean delete(Long id){
        Optional<Produto> produtoBd = _produtoRepository.findById(id);
        if(produtoBd.isPresent()){
            Produto produto = produtoBd.get();
            _produtoRepository.delete(produto);
            return true;
        }
        return false;
    }
}
