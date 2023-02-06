package com.example.projectiot.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class StatisticheSettimanaliDto {

    private long idStatisticheSettimanali;

    private double attivoSettimanale;

    private double inattivoSettimanale;

    private double troppoVicinoSettimanale;

    private double troppoLontanoSettimanale;

    private int numeroPauseBreviSettimanali;

    private int numeroPauseRiposoSettimanali;

    private LocalDate dataInizio;

    private LocalDate dataFine;

    private DipendenteDto dipendente;
}
