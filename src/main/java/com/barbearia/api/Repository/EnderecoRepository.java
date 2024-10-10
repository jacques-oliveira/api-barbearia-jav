package com.barbearia.api.Repository;

import com.barbearia.api.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
