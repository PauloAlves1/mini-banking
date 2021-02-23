package com.br.minibanking.services;

import com.br.minibanking.boundary.pessoa.PessoaRequest;
import com.br.minibanking.domains.DadosPessoaFisica;
import com.br.minibanking.domains.DadosPessoaJuridica;

public interface PessoaService {

    public void criar(PessoaRequest pessoa);
    public void deletar(String documento);
    public void alterar(String documento, PessoaRequest pessoa);
}
