package com.code85.desafio_itau.controller;

import com.code85.desafio_itau.dto.TransacaoRequest;
import com.code85.desafio_itau.service.TransacaoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class TransacaoController {

    private final TransacaoService transacaoService;

    public TransacaoController(TransacaoService transacaoService) {
        this.transacaoService = transacaoService;
    }

    @PostMapping("/transacao")
    @ResponseStatus(HttpStatus.CREATED)
    public void criarTransacao(@RequestBody TransacaoRequest request){
        transacaoService.adicionar(request);
    }

    @DeleteMapping("/transacao")
    @ResponseStatus(HttpStatus.OK)
    public void deletarTransacoes(){
        transacaoService.limpar();
    }
}
