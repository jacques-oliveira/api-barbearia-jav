package com.barbearia.api.Repository;

import com.barbearia.api.model.Produto;
import org.springframework.data.repository.CrudRepository;

public interface ProdutoRepository extends CrudRepository<Produto,Integer> {
}
