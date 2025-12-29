package com.code85.desafio_itau.service;

import com.code85.desafio_itau.dto.TransacaoRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransacaoService {
    private final List<TransacaoRequest> transacoes = new ArrayList<>();

    public void adicionar(TransacaoRequest transacao){
        transacoes.add(transacao);
    }

    public void limpar(){
        transacoes.clear();
    }

    public List<TransacaoRequest> listar(){
        return transacoes;
    }

}
