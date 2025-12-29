package com.code85.desafio_itau.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
public class TransacaoRequest {

    private BigDecimal valor;
    private OffsetDateTime dataHora;

}
