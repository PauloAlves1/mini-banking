package com.br.minibanking.boundary.pessoa;

import com.br.minibanking.domains.Conta;
import com.br.minibanking.domains.Endereco;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
public class PessoaRequest {

    @JsonProperty("nome")
    private String nome;
    @JsonProperty("endereco")
    private Endereco endereco;
    @JsonProperty("telefones")
    private List<String> telefones;
    @JsonProperty("contas")
    private List<Conta> contas;
    @JsonProperty("dados_adicionais")
    private Map<String, Object> dadosAdicionais = new LinkedHashMap<>();

    @JsonAnySetter
    void setDadosAdicionais(String key, Object value) {
        dadosAdicionais.put(key, value);
    }

    public String getDocumento() {
        return dadosAdicionais.get("documento").toString();
    }
}