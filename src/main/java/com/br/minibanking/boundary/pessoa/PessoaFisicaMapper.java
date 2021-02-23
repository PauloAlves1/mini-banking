package com.br.minibanking.boundary.pessoa;


import com.br.minibanking.domains.DadosPessoa;
import com.br.minibanking.domains.DadosPessoaFisica;
import org.springframework.stereotype.Component;

@Component
public class PessoaFisicaMapper {

    public DadosPessoaFisica map(PessoaRequest pessoa){
        DadosPessoaFisica pf = null;
        DadosPessoa dadosPessoa = null;
        try{
            dadosPessoa = DadosPessoa.builder().endereco(pessoa.getEndereco()).nome(pessoa.getNome()).telefones(pessoa.getTelefones()).build();
            pf = DadosPessoaFisica.builder().cpf(pessoa.getDocumento()).dadosPessoa(dadosPessoa).contas(pessoa.getContas() == null? null : pessoa.getContas()).build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return pf;
    }
}
