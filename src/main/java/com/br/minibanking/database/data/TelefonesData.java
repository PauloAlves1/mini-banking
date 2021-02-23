package com.br.minibanking.database.data;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Data
@Builder
@Entity
@Table(name="TELEFONES")
public class TelefonesData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String numero;

    @ManyToOne
    @JoinColumn(name="pessoa_id", nullable=false)
    private PessoaData pessoaData;


}
