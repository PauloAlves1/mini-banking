package com.br.minibanking.database.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Builder
@Entity
@Table(name="conta")
@AllArgsConstructor
@NoArgsConstructor
public class ContaData {
    @Id
    @GeneratedValue
    private Long numero;

    private Double saldo;

    private LocalDate dataCriacao;

    @ManyToOne
    @JoinColumn(name="pessoa_id", nullable=false)
    private PessoaData pessoaData;
}
