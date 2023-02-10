package com.example.projectiot.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Builder
@Getter
@Setter
@Entity
@Table(name = "statistiche_giornaliere")
public class StatisticheGiornaliere implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_statistiche_g")
    private long idStatisticheGiornaliere;

    @Column(name = "attivo")
    private Integer attivoGiornaliero;

    @Column(name = "inattivo")
    private Integer inattivoGiornaliero;

    @Column(name = "troppo_vicino")
    private Integer troppoVicinoGiornaliero;

    @Column(name = "troppo_lontano")
    private Integer troppoLontanoGiornaliero;

    @Column(name = "num_pause_brevi")
    private int numeroPauseBreviGiornaliere;

    @Column(name = "num_pause_riposo")
    private int numeroPauseRiposoGiornaliere;

    @Column(name = "giorno")
    private LocalDate giorno;
    @Column(name = "ora")
    private Integer ora;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dipendente_id")
    private Dipendente dipendente;

    public StatisticheGiornaliere() {

    }

    public StatisticheGiornaliere(Integer attivoGiornaliero, Integer inattivoGiornaliero, Integer troppoVicinoGiornaliero, Integer troppoLontanoGiornaliero, Integer numeroPauseBreviGiornaliere, Integer numeroPauseRiposoGiornaliere, LocalDate giorno, Integer ora, Dipendente dipendente) {
        this.attivoGiornaliero = attivoGiornaliero;
        this.inattivoGiornaliero = inattivoGiornaliero;
        this.troppoVicinoGiornaliero = troppoVicinoGiornaliero;
        this.troppoLontanoGiornaliero = troppoLontanoGiornaliero;
        this.numeroPauseBreviGiornaliere = numeroPauseBreviGiornaliere;
        this.numeroPauseRiposoGiornaliere = numeroPauseRiposoGiornaliere;
        this.giorno = giorno;
        this.ora = ora;
        this.dipendente = dipendente;
    }

    public StatisticheGiornaliere(long idStatisticheGiornaliere, Integer attivoGiornaliero, Integer inattivoGiornaliero, Integer troppoVicinoGiornaliero, Integer troppoLontanoGiornaliero, Integer numeroPauseBreviGiornaliere, Integer numeroPauseRiposoGiornaliere, LocalDate giorno, Integer ora, Dipendente dipendente) {
        this.idStatisticheGiornaliere = idStatisticheGiornaliere;
        this.attivoGiornaliero = attivoGiornaliero;
        this.inattivoGiornaliero = inattivoGiornaliero;
        this.troppoVicinoGiornaliero = troppoVicinoGiornaliero;
        this.troppoLontanoGiornaliero = troppoLontanoGiornaliero;
        this.numeroPauseBreviGiornaliere = numeroPauseBreviGiornaliere;
        this.numeroPauseRiposoGiornaliere = numeroPauseRiposoGiornaliere;
        this.giorno = giorno;
        this.ora = ora;

        this.dipendente = dipendente;
    }
/*
    public StatisticheGiornaliere(long idStatisticheGiornaliere, Integer attivoGiornaliero, Integer inattivoGiornaliero, Integer troppoVicinoGiornaliero, Integer troppoLontanoGiornaliero, Integer numeroPauseBreviGiornaliere, Integer numeroPauseRiposoGiornaliere) {
        this.idStatisticheGiornaliere = idStatisticheGiornaliere;
        this.attivoGiornaliero = attivoGiornaliero;
        this.inattivoGiornaliero = inattivoGiornaliero;
        this.troppoVicinoGiornaliero = troppoVicinoGiornaliero;
        this.troppoLontanoGiornaliero = troppoLontanoGiornaliero;
        this.numeroPauseBreviGiornaliere = numeroPauseBreviGiornaliere;
        this.numeroPauseRiposoGiornaliere = numeroPauseRiposoGiornaliere;
    }*/
}

