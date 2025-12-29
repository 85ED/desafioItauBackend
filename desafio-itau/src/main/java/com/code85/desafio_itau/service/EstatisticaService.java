package com.code85.desafio_itau.service;

import com.code85.desafio_itau.dto.EstatisticaResponse;
import com.code85.desafio_itau.dto.TransacaoRequest;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;

@Service
public class EstatisticaService {

    private final TransacaoService transacaoService;

    public EstatisticaService(TransacaoService transacaoService) {
        this.transacaoService = transacaoService;
    }

    public EstatisticaResponse calcular() {
        OffsetDateTime limite = OffsetDateTime.now().minusSeconds(60);
        List<TransacaoRequest> transacoes = transacaoService.listar();

        double sum = 0;
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
        long count = 0;

        for (TransacaoRequest t : transacoes) {
            if (t.getDataHora().isBefore(limite)) continue;

            double valor = t.getValor().doubleValue();
            sum += valor;
            min = Math.min(min, valor);
            max = Math.max(max, valor);
            count++;
        }

        if (count == 0) {
            return new EstatisticaResponse(0, 0, 0, 0, 0);
        }

        return new EstatisticaResponse(
                count,
                sum,
                sum / count,
                min,
                max
        );
    }
}
