package com.example.projectiot.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "statistiche_giornaliere")
public class StatisticheGiornaliere implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_statistiche_g")
    private long idStatisticheGiornaliere;

    @Column(name = "attivo")
    private double attivoGiornaliero;

    @Column(name = "inattivo")
    private double inattivoGiornaliero;

    @Column(name = "troppo_vicino")
    private double troppoVicinoGiornaliero;

    @Column(name = "troppo_lontano")
    private double troppoLontanoGiornaliero;

    @Column(name = "num_pause_brevi")
    private int numeroPauseBreviGiornaliere;

    @Column(name = "num_pause_riposo")
    private int numeroPauseRiposoGiornaliere;

    @Column(name = "giorno")
    private LocalDate giorno;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dipendente_id")
    private Dipendente dipendente;

    public StatisticheGiornaliere() {
    }

    public StatisticheGiornaliere(double attivoGiornaliero, double inattivoGiornaliero, double troppoVicinoGiornaliero, double troppoLontanoGiornaliero, int numeroPauseBreviGiornaliere, int numeroPauseRiposoGiornaliere, LocalDate giorno, Dipendente dipendente) {
        this.attivoGiornaliero = attivoGiornaliero;
        this.inattivoGiornaliero = inattivoGiornaliero;
        this.troppoVicinoGiornaliero = troppoVicinoGiornaliero;
        this.troppoLontanoGiornaliero = troppoLontanoGiornaliero;
        this.numeroPauseBreviGiornaliere = numeroPauseBreviGiornaliere;
        this.numeroPauseRiposoGiornaliere = numeroPauseRiposoGiornaliere;
        this.giorno = giorno;
        this.dipendente = dipendente;
    }

    public StatisticheGiornaliere(long idStatisticheGiornaliere, double attivoGiornaliero, double inattivoGiornaliero, double troppoVicinoGiornaliero, double troppoLontanoGiornaliero, int numeroPauseBreviGiornaliere, int numeroPauseRiposoGiornaliere, LocalDate giorno, Dipendente dipendente) {
        this.idStatisticheGiornaliere = idStatisticheGiornaliere;
        this.attivoGiornaliero = attivoGiornaliero;
        this.inattivoGiornaliero = inattivoGiornaliero;
        this.troppoVicinoGiornaliero = troppoVicinoGiornaliero;
        this.troppoLontanoGiornaliero = troppoLontanoGiornaliero;
        this.numeroPauseBreviGiornaliere = numeroPauseBreviGiornaliere;
        this.numeroPauseRiposoGiornaliere = numeroPauseRiposoGiornaliere;
        this.giorno = giorno;
        this.dipendente = dipendente;
    }

    public long getIdStatisticheGiornaliere() {
        return idStatisticheGiornaliere;
    }

    public void setIdStatisticheGiornaliere(long idStatisticheGiornaliere) {
        this.idStatisticheGiornaliere = idStatisticheGiornaliere;
    }

    public double getAttivoGiornaliero() {
        return attivoGiornaliero;
    }

    public void setAttivoGiornaliero(double attivoGiornaliero) {
        this.attivoGiornaliero = attivoGiornaliero;
    }

    public double getInattivoGiornaliero() {
        return inattivoGiornaliero;
    }

    public void setInattivoGiornaliero(double inattivoGiornaliero) {
        this.inattivoGiornaliero = inattivoGiornaliero;
    }

    public double getTroppoVicinoGiornaliero() {
        return troppoVicinoGiornaliero;
    }

    public void setTroppoVicinoGiornaliero(double troppoVicinoGiornaliero) {
        this.troppoVicinoGiornaliero = troppoVicinoGiornaliero;
    }

    public double getTroppoLontanoGiornaliero() {
        return troppoLontanoGiornaliero;
    }

    public void setTroppoLontanoGiornaliero(double troppoLontanoGiornaliero) {
        this.troppoLontanoGiornaliero = troppoLontanoGiornaliero;
    }

    public int getNumeroPauseBreviGiornaliere() {
        return numeroPauseBreviGiornaliere;
    }

    public void setNumeroPauseBreviGiornaliere(int numeroPauseBreviGiornaliere) {
        this.numeroPauseBreviGiornaliere = numeroPauseBreviGiornaliere;
    }

    public int getNumeroPauseRiposoGiornaliere() {
        return numeroPauseRiposoGiornaliere;
    }

    public void setNumeroPauseRiposoGiornaliere(int numeroPauseRiposoGiornaliere) {
        this.numeroPauseRiposoGiornaliere = numeroPauseRiposoGiornaliere;
    }

    public LocalDate getGiorno() {
        return giorno;
    }

    public void setGiorno(LocalDate giorno) {
        this.giorno = giorno;
    }

    public Dipendente getDipendente() {
        return dipendente;
    }

    public void setDipendente(Dipendente dipendente) {
        this.dipendente = dipendente;
    }
}

