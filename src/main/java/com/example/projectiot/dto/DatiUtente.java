package com.example.projectiot.dto;

import lombok.Data;

@Data
public class DatiUtente {
    private String troppoVicino;
    private String troppoLontano;
    private String tempoAttivo;
    private String tempoInattivo;
    private String numPauseBrevi;
    private String numPauseLunghe;
}
