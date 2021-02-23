package com.br.minibanking.boundary.conta;

import com.br.minibanking.boundary.pessoa.PessoaServiceImpl;
import com.br.minibanking.domains.Conta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mini-banking/")
@ResponseBody
public class ContaController {

    @Autowired
    ContaServiceImpl contaService;

    @Autowired
    PessoaServiceImpl pessoaService;

    @PostMapping("contas/{documento}")
    public ResponseEntity<?> criar(@PathVariable("documento") String documento, @RequestBody Conta conta){
        try {
            contaService.criar(documento, conta);
        } catch(Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("contas/{numero}")
    public ResponseEntity<?> consultar(@PathVariable("numero") String numero){
        try {
            contaService.consultar(numero);
        } catch(Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PatchMapping("contas/depositar/{numero}")
    public ResponseEntity<?> depositar(@PathVariable("numero") String numero, @RequestBody Double valor){
        try {
            contaService.depositar(valor);
        } catch(Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
