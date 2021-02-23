package com.br.minibanking.domains;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@Builder
@ToString
public class Conta {
    @Id
    @GeneratedValue
    @JsonProperty("numero")
    private Integer numero;
    @JsonProperty("saldo")
    private Double saldo;

    private LocalDate dataCriacao;
}
