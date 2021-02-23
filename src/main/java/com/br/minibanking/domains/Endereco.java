package com.br.minibanking.domains;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Endereco {

    @JsonProperty("rua")
    private String rua;
    @JsonProperty("numero")
    private String numero;
    @JsonProperty("complemento")
    private String complemento;
    @JsonProperty("cep")
    private String cep;
}
