package com.br.minibanking.domains;

import com.fasterxml.jackson.annotation.JsonProperty;
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
