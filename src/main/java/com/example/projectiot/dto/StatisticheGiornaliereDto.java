package com.example.projectiot.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class StatisticheGiornaliereDto {

    private long idStatisticheGiornaliere;

    private double attivoGiornaliero;

    private double inattivoGiornaliero;

    private double troppoVicinoGiornaliero;

    private double troppoLontanoGiornaliero;

    private int numeroPauseBreviGiornaliere;

    private int numeroPauseRiposoGiornaliere;

    private LocalDate giorno;

    private DipendenteDto dipendente;
}
