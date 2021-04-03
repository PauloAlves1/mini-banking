package com.br.minibanking.boundary.pessoa;

import com.br.minibanking.boundary.pessoa.dto.AlterarPessoaRequest;
import com.br.minibanking.boundary.pessoa.dto.PessoaRequest;
import com.br.minibanking.database.data.PessoaData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/mini-banking/")
@ResponseBody
public class PessoaController {

    private static final Logger logger = LoggerFactory.getLogger(PessoaController.class);

    @Autowired
    PessoaServiceImpl pessoaService;


    @GetMapping("pessoas")
    public ResponseEntity<List<PessoaData>> listar() {
        logger.info("Buscar lista de pessoas");
        return ResponseEntity.ok(pessoaService.listarPessoas());
    }

    @PostMapping("pessoas")
    public ResponseEntity<PessoaData> criar(@RequestBody PessoaRequest pessoa){
        logger.info("Criar pessoa");
        return new ResponseEntity<>(pessoaService.criar(pessoa), HttpStatus.CREATED);
    }

    @DeleteMapping("pessoas/{id}")
    public ResponseEntity<Void> deletar(@PathVariable long id){
        logger.info("Deletar pessoa");
        pessoaService.deletar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("pessoas")
    public ResponseEntity<?> alterar(@RequestBody AlterarPessoaRequest pessoa){
        logger.info("Alterar pessoa");
        pessoaService.alterar(pessoa);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("pessoas/{id}")
    public ResponseEntity<PessoaData> buscarPorId(@PathVariable long id) {
        logger.info("Buscar pessoa");
        return new ResponseEntity<>(pessoaService.buscarPorId(id), HttpStatus.OK);
    }
}
