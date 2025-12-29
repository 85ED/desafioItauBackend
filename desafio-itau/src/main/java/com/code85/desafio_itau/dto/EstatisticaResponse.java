package com.code85.desafio_itau.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EstatisticaResponse {

    private Long count;
    private Double sum;
    private Double avg;
    private Double max;
    private Double min;

}
