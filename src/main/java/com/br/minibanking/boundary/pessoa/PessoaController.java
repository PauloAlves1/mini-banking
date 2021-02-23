package com.br.minibanking.boundary.pessoa;

import com.br.minibanking.domains.DadosPessoaFisica;
import com.br.minibanking.domains.DadosPessoaJuridica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mini-banking/")
@ResponseBody
public class PessoaController {

    @Autowired
    PessoaServiceImpl pessoaService;

    @PostMapping("pessoas")
    public ResponseEntity<?> criar(@RequestBody PessoaRequest pessoa){
        try {
            pessoaService.criar(pessoa);
        } catch(Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("pessoas/{documento}")
    public ResponseEntity<?> deletar(@PathVariable("documento") String documento){
        try {
            pessoaService.deletar(documento);
        } catch(Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("pessoas/{documento}")
    public ResponseEntity<?> alterar(@PathVariable("documento") String documento, PessoaRequest pessoa){
        try {
            pessoaService.alterar(documento, pessoa);
        } catch(Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }


//    @GetMapping("pessoas/{documento}")
//    public ResponseEntity<?> consultar(@PathVariable("documento") String documento){
//        try {
//            pessoaService.
//        } catch(Exception e) {
//            throw new RuntimeException(e);
//        }
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
}
