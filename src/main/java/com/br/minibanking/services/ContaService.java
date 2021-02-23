package com.br.minibanking.services;

import com.br.minibanking.domains.Conta;

public interface ContaService {

    public void criar(String cpf, Conta conta);
    public void consultar(String numero);
    public void depositar(Double valor);
}
