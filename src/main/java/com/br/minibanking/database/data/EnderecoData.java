package com.br.minibanking.database.data;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Data
@Builder
@Entity
@Table(name="ENDERECO")
public class EnderecoData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String rua;
    private String numero;
    private String complemento;
    private String cep;

    @OneToOne
    @JoinColumn(name="pessoa_id", nullable=false)
    private PessoaData pessoaData;


}
