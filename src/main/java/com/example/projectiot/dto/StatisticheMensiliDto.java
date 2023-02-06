package com.example.projectiot.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class StatisticheMensiliDto {

    private long idStatisticheMensili;

    private double attivoMensile;

    private double inattivoMensile;

    private double troppoVicinoMensile;

    private double troppoLontanoMensile;

    private int numeroPauseBreviMensili;

    private int numeroPauseRiposoMensili;

    private LocalDate mese;

    private DipendenteDto dipendente;
}
