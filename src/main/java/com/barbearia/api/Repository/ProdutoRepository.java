package com.barbearia.api.Repository;

import com.barbearia.api.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ProdutoRepository extends JpaRepository<Produto,Long> {
}
