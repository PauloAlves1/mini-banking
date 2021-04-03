package com.br.minibanking.boundary.pessoa;

import com.br.minibanking.boundary.pessoa.dto.AlterarPessoaRequest;
import com.br.minibanking.boundary.pessoa.dto.PessoaRequest;
import com.br.minibanking.boundary.pessoa.mappers.PessoaFisicaMapper;
import com.br.minibanking.boundary.pessoa.mappers.PessoaJuridicaMapper;
import com.br.minibanking.database.data.EnderecoData;
import com.br.minibanking.database.data.PessoaData;
import com.br.minibanking.database.repositories.PessoaRepository;
import com.br.minibanking.domains.DadosPessoaFisica;
import com.br.minibanking.domains.DadosPessoaJuridica;
import com.br.minibanking.domains.Endereco;
import com.br.minibanking.domains.ErroInternoException;
import com.br.minibanking.services.PessoaService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PessoaServiceImpl implements PessoaService {

    private static final Logger logger = LoggerFactory.getLogger(PessoaServiceImpl.class);

    private static final String TIPO_DOCUMENTO_PESSOA_FISICA = "cpf";
    private static final String TIPO_DOCUMENTO_PESSOA_JURIDICA = "cnpj";

    @Autowired
    PessoaFisicaMapper pessoaFisicaMapper;

    @Autowired
    PessoaJuridicaMapper pessoaJuridicaMapper;

    private final PessoaRepository pessoaRepository;

    public PessoaData criar(PessoaRequest pessoa) {

        logger.info("Iniciando processo de criação da pessoa");

        if (pessoa.getDocumento().length() == 11) {
            try {
                logger.info("Iniciando a conversão da pessoa para o dominio DadosPessoaFisica");
                DadosPessoaFisica pf = pessoaFisicaMapper.map(pessoa);
                logger.info("Dominio criado com sucesso: {}", pf.toString());

                logger.info("Salvando pessoa no banco de dados");
                return pessoaRepository.save(PessoaData.builder()
                        .telefone(pf.getDadosPessoa().getTelefone())
                        .documento(pf.getCpf())
                        .tipoDocumento(TIPO_DOCUMENTO_PESSOA_FISICA)
                        .endereco(enderecoParaEnderecoData(pf.getDadosPessoa().getEndereco()))
                        .contas(null)
                        .nome(pf.getDadosPessoa().getNome())
                        .build());
            } catch (Exception e) {
                logger.info("Erro ao criar pessoa.");
                throw new ErroInternoException(e.getMessage(), e.getCause());
            }
        } else {
            try {
                logger.info("Iniciando a conversão da pessoa para o dominio DadosPessoaJuridica");
                DadosPessoaJuridica pj = pessoaJuridicaMapper.map(pessoa);
                logger.info("Dominio criado com sucesso: {}", pj.toString());

                logger.info("Salvando o PessoaData");
                return pessoaRepository.save(PessoaData.builder()
                        .nome(pj.getDadosPessoa().getNome())
                        .documento(pj.getCnpj())
                        .tipoDocumento(TIPO_DOCUMENTO_PESSOA_JURIDICA)
                        .endereco(enderecoParaEnderecoData(pj.getDadosPessoa().getEndereco()))
                        .contas(null)
                        .telefone(pj.getDadosPessoa().getTelefone())
                        .build());
            } catch (Exception e) {
                logger.info("Erro ao criar pessoa.");
                throw new ErroInternoException(e.getMessage(), e.getCause());
            }
        }
    }

    @Override
    public void deletar(long id) {
        pessoaRepository.deleteById(id);
    }

    @Override
    public void alterar(AlterarPessoaRequest pessoa) {
        PessoaData pessoaAtual = buscarPorId(pessoa.getId());

        // adicionar os dados de input nos dados consultados
    }

    public List<PessoaData> listarPessoas() {
        return pessoaRepository.findAll();
    }

    public PessoaData buscarPorId(long id) {
        return pessoaRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Pessoa não encontrada"));
    }

    private EnderecoData enderecoParaEnderecoData(Endereco endereco) {
        return EnderecoData.builder()
                .rua(endereco.getRua())
                .numero(endereco.getNumero())
                .complemento(endereco.getComplemento())
                .cep(endereco.getCep())
                .build();
    }

}
