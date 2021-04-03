package com.br.minibanking.database.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@Entity
@Table(name="pessoa")
@AllArgsConstructor
@NoArgsConstructor
public class PessoaData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String documento;

    private String tipoDocumento;

    @OneToOne(cascade=CascadeType.PERSIST)
    private EnderecoData endereco;

    @OneToMany(cascade=CascadeType.PERSIST)
    private List<ContaData> contas;

    private String telefone;

}
