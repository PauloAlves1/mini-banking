package com.br.minibanking.domains;

import lombok.*;

import java.util.List;

@Data
@Builder
@ToString
public class DadosPessoaJuridica {

    private String cnpj;

    private List<Conta> contas;

    private DadosPessoa dadosPessoa;
}
