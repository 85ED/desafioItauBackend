package com.code85.desafio_itau.service;
import com.code85.desafio_itau.dto.TransacaoRequest;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TransacaoService {
    private final List<TransacaoRequest> transacoes = new ArrayList<>();

    public void adicionar(TransacaoRequest transacao){

        if (transacao.getValor() == null || transacao.getDataHora() == null) {
            throw new IllegalArgumentException("Valor e data/hora da transação não podem ser nulos");
        }

        if (transacao.getValor().compareTo(BigDecimal.ZERO) < 0){
            throw new IllegalArgumentException("Valor da transação não pode ser negativo");
        }
        if (transacao.getDataHora().isAfter(OffsetDateTime.now())){
            throw new IllegalArgumentException("Data e hora da transação não podem ser no futuro");
        }
        transacoes.add(transacao);
    }

    public void limpar(){
        transacoes.clear();
    }

    public List<TransacaoRequest> listar(){
        return transacoes;
    }



}
