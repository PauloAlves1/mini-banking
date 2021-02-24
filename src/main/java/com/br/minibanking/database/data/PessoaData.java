package com.br.minibanking.database.data;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@Entity
@Table(name="pessoa")
public class PessoaData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String documento;

    @OneToOne
    private EnderecoData endereco;

    @OneToMany
    @JoinColumn(name="pessoa_id")
    private List<ContaData> conta;

    private String telefone;
}
