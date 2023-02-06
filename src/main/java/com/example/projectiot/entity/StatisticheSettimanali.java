package com.example.projectiot.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "statistiche_settimanali")
public class StatisticheSettimanali implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_statistiche_s")
    private long idStatisticheSettimanali;

    @Column(name = "attivo")
    private double attivoSettimanale;

    @Column(name = "inattivo")
    private double inattivoSettimanale;

    @Column(name = "troppo_vicino")
    private double troppoVicinoSettimanale;

    @Column(name = "troppo_lontano")
    private double troppoLontanoSettimanale;

    @Column(name = "num_pause_brevi")
    private int numeroPauseBreviSettimanali;

    @Column(name = "num_pause_riposo")
    private int numeroPauseRiposoSettimanali;

    @Column(name = "data_inizio")
    private LocalDate dataInizio;

    @Column(name = "data_fine")
    private LocalDate dataFine;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dipendente_id")
    private Dipendente dipendente;

    public StatisticheSettimanali() {
    }

    public StatisticheSettimanali(double attivoSettimanale, double inattivoSettimanale, double troppoVicinoSettimanale, double troppoLontanoSettimanale, int numeroPauseBreviSettimanali, int numeroPauseRiposoSettimanali, LocalDate dataInizio, LocalDate dataFine, Dipendente dipendente) {
        this.attivoSettimanale = attivoSettimanale;
        this.inattivoSettimanale = inattivoSettimanale;
        this.troppoVicinoSettimanale = troppoVicinoSettimanale;
        this.troppoLontanoSettimanale = troppoLontanoSettimanale;
        this.numeroPauseBreviSettimanali = numeroPauseBreviSettimanali;
        this.numeroPauseRiposoSettimanali = numeroPauseRiposoSettimanali;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.dipendente = dipendente;
    }

    public StatisticheSettimanali(long idStatisticheSettimanali, double attivoSettimanale, double inattivoSettimanale, double troppoVicinoSettimanale, double troppoLontanoSettimanale, int numeroPauseBreviSettimanali, int numeroPauseRiposoSettimanali, LocalDate dataInizio, LocalDate dataFine, Dipendente dipendente) {
        this.idStatisticheSettimanali = idStatisticheSettimanali;
        this.attivoSettimanale = attivoSettimanale;
        this.inattivoSettimanale = inattivoSettimanale;
        this.troppoVicinoSettimanale = troppoVicinoSettimanale;
        this.troppoLontanoSettimanale = troppoLontanoSettimanale;
        this.numeroPauseBreviSettimanali = numeroPauseBreviSettimanali;
        this.numeroPauseRiposoSettimanali = numeroPauseRiposoSettimanali;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.dipendente = dipendente;
    }

    public long getIdStatisticheSettimanali() {
        return idStatisticheSettimanali;
    }

    public void setIdStatisticheSettimanali(long idStatisticheSettimanali) {
        this.idStatisticheSettimanali = idStatisticheSettimanali;
    }

    public double getAttivoSettimanale() {
        return attivoSettimanale;
    }

    public void setAttivoSettimanale(double attivoSettimanale) {
        this.attivoSettimanale = attivoSettimanale;
    }

    public double getInattivoSettimanale() {
        return inattivoSettimanale;
    }

    public void setInattivoSettimanale(double inattivoSettimanale) {
        this.inattivoSettimanale = inattivoSettimanale;
    }

    public double getTroppoVicinoSettimanale() {
        return troppoVicinoSettimanale;
    }

    public void setTroppoVicinoSettimanale(double troppoVicinoSettimanale) {
        this.troppoVicinoSettimanale = troppoVicinoSettimanale;
    }

    public double getTroppoLontanoSettimanale() {
        return troppoLontanoSettimanale;
    }

    public void setTroppoLontanoSettimanale(double troppoLontanoSettimanale) {
        this.troppoLontanoSettimanale = troppoLontanoSettimanale;
    }

    public int getNumeroPauseBreviSettimanali() {
        return numeroPauseBreviSettimanali;
    }

    public void setNumeroPauseBreviSettimanali(int numeroPauseBreviSettimanali) {
        this.numeroPauseBreviSettimanali = numeroPauseBreviSettimanali;
    }

    public int getNumeroPauseRiposoSettimanali() {
        return numeroPauseRiposoSettimanali;
    }

    public void setNumeroPauseRiposoSettimanali(int numeroPauseRiposoSettimanali) {
        this.numeroPauseRiposoSettimanali = numeroPauseRiposoSettimanali;
    }

    public LocalDate getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(LocalDate dataInizio) {
        this.dataInizio = dataInizio;
    }

    public LocalDate getDataFine() {
        return dataFine;
    }

    public void setDataFine(LocalDate dataFine) {
        this.dataFine = dataFine;
    }

    public Dipendente getDipendente() {
        return dipendente;
    }

    public void setDipendente(Dipendente dipendente) {
        this.dipendente = dipendente;
    }
}

