package com.example.projectiot.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class DatiUtente {
    private Integer troppoVicino;
    private Integer troppoLontano;
    private Integer tempoAttivo;
    private Integer tempoInattivo;
    private Integer numPauseBrevi;
    private Integer numPauseLunghe;
}
