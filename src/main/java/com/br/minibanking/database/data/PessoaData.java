package com.br.minibanking.database.data;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@Entity
@Table(name="PESSOA")
public class PessoaData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    @OneToOne(mappedBy="pessoa")
    private EnderecoData endereco;

    @OneToMany(mappedBy="pessoa")
    private ContaData conta;

    @OneToMany(mappedBy="pessoa")
    private List<TelefonesData> telefones;
}
