package com.code85.desafio_itau.controller;

import com.code85.desafio_itau.dto.EstatisticaResponse;
import com.code85.desafio_itau.service.EstatisticaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EstatisticaController {

    private final EstatisticaService estatisticaService;

    public EstatisticaController(EstatisticaService estatisticaService) {
        this.estatisticaService = estatisticaService;
    }

    @GetMapping("/estatistica")
    public EstatisticaResponse obter() {
        return estatisticaService.calcular();
    }
}
