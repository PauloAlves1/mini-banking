package com.br.minibanking.boundary.pessoa.mappers;


import com.br.minibanking.boundary.pessoa.dto.PessoaRequest;
import com.br.minibanking.domains.DadosPessoa;
import com.br.minibanking.domains.DadosPessoaFisica;
import org.springframework.stereotype.Component;

@Component
public class PessoaFisicaMapper {

    public DadosPessoaFisica map(PessoaRequest pessoa){
        DadosPessoaFisica pf;
        DadosPessoa dadosPessoa;
        try{
            dadosPessoa = DadosPessoa.builder()
                    .endereco(pessoa.getEndereco())
                    .nome(pessoa.getNome())
                    .telefone(pessoa.getTelefone())
                    .build();
            pf = DadosPessoaFisica.builder()
                    .cpf(pessoa.getDocumento())
                    .dadosPessoa(dadosPessoa)
                    .contas(pessoa.getContas() == null? null : pessoa.getContas())
                    .build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return pf;
    }
}
