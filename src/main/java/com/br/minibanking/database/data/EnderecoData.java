package com.br.minibanking.database.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@Entity
@Table(name="endereco")
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String rua;
    private String numero;
    private String complemento;
    private String cep;

    @OneToOne()
    @JoinColumn(name="pessoa_id")
    private PessoaData pessoaData;


}
