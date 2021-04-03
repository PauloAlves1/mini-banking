package com.br.minibanking.domains;

import lombok.*;

@Data
@ToString
@Builder
public class DadosPessoa {

    private String nome;

    private Endereco endereco;

    private String telefone;
}
