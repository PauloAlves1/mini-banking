package com.br.minibanking.domains;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@ToString
@Builder
public class DadosPessoa {

    private String nome;

    private Endereco endereco;

    private String telefone;
}
