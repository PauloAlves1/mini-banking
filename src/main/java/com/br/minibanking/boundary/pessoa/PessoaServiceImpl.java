package com.br.minibanking.boundary.pessoa;

import com.br.minibanking.database.data.PessoaData;
import com.br.minibanking.database.repositories.PessoaRepository;
import com.br.minibanking.domains.DadosPessoaFisica;
import com.br.minibanking.domains.DadosPessoaJuridica;
import com.br.minibanking.services.PessoaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PessoaServiceImpl implements PessoaService {

    @Autowired
    PessoaFisicaMapper pessoaFisicaMapper;

    @Autowired
    PessoaJuridicaMapper pessoaJuridicaMapper;

    private final PessoaRepository pessoaRepository;

    public PessoaData criar(PessoaRequest pessoa) {
        System.out.println("iniciando processo de criação da pessoa");
        if(pessoa.getDocumento().length() == 11) {
                DadosPessoaFisica pf = pessoaFisicaMapper.map(pessoa);
                System.out.println(pf.toString());
                PessoaData pessoaData = PessoaData.builder().telefone(pf.getDadosPessoa().getTelefone()).documento(pf.getCpf()).nome(pf.getDadosPessoa().getNome()).build();
                return pessoaRepository.save(pessoaData);
        } else {
                DadosPessoaJuridica pj = pessoaJuridicaMapper.map(pessoa);
                System.out.println(pj.toString());
                PessoaData pessoaData = PessoaData.builder().telefone(pj.getDadosPessoa().getTelefone()).documento(pj.getCnpj()).nome(pj.getDadosPessoa().getNome()).build();
                return pessoaRepository.save(pessoaData);
        }
    }

    @Override
    public void deletar(String documento) {

    }

    @Override
    public void alterar(String documento, PessoaRequest pessoa) {

    }

    public List<PessoaData> listarPessoas(){
        return pessoaRepository.findAll();
    }

    public PessoaData buscarPorId(long id) {
        return pessoaRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Pessoa não encontrada"));
    }

}
