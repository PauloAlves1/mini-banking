package com.br.minibanking.services;

import com.br.minibanking.boundary.pessoa.dto.AlterarPessoaRequest;
import com.br.minibanking.boundary.pessoa.dto.PessoaRequest;
import com.br.minibanking.database.data.PessoaData;

public interface PessoaService {

    PessoaData criar(PessoaRequest pessoa);
    void deletar(long id);
    void alterar(AlterarPessoaRequest pessoa);
}
