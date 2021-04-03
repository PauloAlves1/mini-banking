package com.br.minibanking.domains;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ErroInternoException extends RuntimeException{

    private static final String CODIGO_ERRO_PADRAO = "500";

    private String codigoErro;

    private String mensagemErro;

    private Throwable stackTraceErro;

    public ErroInternoException(String mensagemErro, Throwable stackTraceErro) {
        super(mensagemErro, stackTraceErro);
        this.codigoErro = CODIGO_ERRO_PADRAO;
        this.mensagemErro = mensagemErro;
        this.stackTraceErro = stackTraceErro;
    }

}
