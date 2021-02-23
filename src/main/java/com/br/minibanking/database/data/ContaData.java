package com.br.minibanking.database.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Builder
@Entity
@Table(name="CONTA")
public class ContaData {
    @Id
    @GeneratedValue
    private Integer numero;

    private Double saldo;

    private LocalDate dataCriacao;

    @ManyToOne
    @JoinColumn(name="pessoa_id", nullable=false)
    private PessoaData pessoaData;
}