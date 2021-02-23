package com.br.minibanking.boundary.conta;

import com.br.minibanking.domains.Conta;
import com.br.minibanking.services.ContaService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ContaServiceImpl implements ContaService {
    @Override
    public void criar(String cpf, Conta conta) {
        LocalDate date = LocalDate.now();
        conta.setDataCriacao(date);


    }

    @Override
    public void consultar(String numero) {
        System.out.println("consultado");
    }

    @Override
    public void depositar(Double valor) {
        System.out.println("100000");
    }
}
