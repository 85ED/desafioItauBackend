package com.code85.desafio_itau.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EstatisticaResponse {

    private long count;
    private double sum;
    private double avg;
    private double max;
    private double min;

}
