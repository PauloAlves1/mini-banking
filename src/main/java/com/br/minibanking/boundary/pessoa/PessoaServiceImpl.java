package com.br.minibanking.boundary.pessoa;

import com.br.minibanking.domains.DadosPessoaFisica;
import com.br.minibanking.domains.DadosPessoaJuridica;
import com.br.minibanking.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaServiceImpl implements PessoaService {

    @Autowired
    PessoaFisicaMapper pessoaFisicaMapper;

    @Autowired
    PessoaJuridicaMapper pessoaJuridicaMapper;

    @Override
    public void criar(PessoaRequest pessoa) {
        System.out.println("iniciando processo de criação da pessoa");
        if(pessoa.getDocumento().length() == 11) {
                DadosPessoaFisica pf = pessoaFisicaMapper.map(pessoa);
                System.out.println(pf.toString());
        } else {
                DadosPessoaJuridica pj = pessoaJuridicaMapper.map(pessoa);
                System.out.println(pj.toString());
        }
    }

    @Override
    public void deletar(String documento) {

    }

    @Override
    public void alterar(String documento, PessoaRequest pessoa) {

    }

}
