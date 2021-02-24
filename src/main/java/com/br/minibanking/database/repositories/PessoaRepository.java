package com.br.minibanking.database.repositories;

import com.br.minibanking.database.data.PessoaData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<PessoaData, Long> {
}
