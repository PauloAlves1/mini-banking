package com.br.minibanking.boundary.pessoa.mappers;

import com.br.minibanking.boundary.pessoa.dto.PessoaRequest;
import com.br.minibanking.domains.DadosPessoa;
import com.br.minibanking.domains.DadosPessoaJuridica;
import org.springframework.stereotype.Component;

@Component
public class PessoaJuridicaMapper {

    public DadosPessoaJuridica map(PessoaRequest pessoa) {
        DadosPessoaJuridica pj;
        DadosPessoa dadosPessoa;
        try{
            dadosPessoa = DadosPessoa.builder()
                    .endereco(pessoa.getEndereco())
                    .nome(pessoa.getNome())
                    .telefone(pessoa.getTelefone())
                    .build();
            pj = DadosPessoaJuridica.builder()
                    .cnpj(pessoa.getDocumento())
                    .dadosPessoa(dadosPessoa)
                    .contas(pessoa.getContas() == null? null : pessoa.getContas())
                    .build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return pj;
    }
}
