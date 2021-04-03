package com.br.minibanking.domains;

import lombok.*;

import java.util.List;

@Data
@Builder
@ToString
public class DadosPessoaFisica {

    private String cpf;

    private List<Conta> contas;

    private DadosPessoa dadosPessoa;

}
