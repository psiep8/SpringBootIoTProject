package com.example.projectiot.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "statistiche_mensili")
public class StatisticheMensili implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_statistiche_m")
    private long idStatisticheMensili;

    @Column(name = "attivo")
    private double attivoMensile;

    @Column(name = "inattivo")
    private double inattivoMensile;

    @Column(name = "troppo_vicino")
    private double troppoVicinoMensile;

    @Column(name = "troppo_lontano")
    private double troppoLontanoMensile;

    @Column(name = "num_pause_brevi")
    private int numeroPauseBreviMensili;

    @Column(name = "num_pause_riposo")
    private int numeroPauseRiposoMensili;


    @Column(name = "mese")
    private LocalDate mese;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dipendente_id")
    private Dipendente dipendente;

    public StatisticheMensili() {
    }

    public StatisticheMensili(double attivoMensile, double inattivoMensile, double troppoVicinoMensile, double troppoLontanoMensile, int numeroPauseBreviMensili, int numeroPauseRiposoMensili, LocalDate mese, Dipendente dipendente) {
        this.attivoMensile = attivoMensile;
        this.inattivoMensile = inattivoMensile;
        this.troppoVicinoMensile = troppoVicinoMensile;
        this.troppoLontanoMensile = troppoLontanoMensile;
        this.numeroPauseBreviMensili = numeroPauseBreviMensili;
        this.numeroPauseRiposoMensili = numeroPauseRiposoMensili;
        this.mese = mese;
        this.dipendente = dipendente;
    }

    public StatisticheMensili(long idStatisticheMensili, double attivoMensile, double inattivoMensile, double troppoVicinoMensile, double troppoLontanoMensile, int numeroPauseBreviMensili, int numeroPauseRiposoMensili, LocalDate mese, Dipendente dipendente) {
        this.idStatisticheMensili = idStatisticheMensili;
        this.attivoMensile = attivoMensile;
        this.inattivoMensile = inattivoMensile;
        this.troppoVicinoMensile = troppoVicinoMensile;
        this.troppoLontanoMensile = troppoLontanoMensile;
        this.numeroPauseBreviMensili = numeroPauseBreviMensili;
        this.numeroPauseRiposoMensili = numeroPauseRiposoMensili;
        this.mese = mese;
        this.dipendente = dipendente;
    }

    public long getIdStatisticheMensili() {
        return idStatisticheMensili;
    }

    public void setIdStatisticheMensili(long idStatisticheMensili) {
        this.idStatisticheMensili = idStatisticheMensili;
    }

    public double getAttivoMensile() {
        return attivoMensile;
    }

    public void setAttivoMensile(double attivoMensile) {
        this.attivoMensile = attivoMensile;
    }

    public double getInattivoMensile() {
        return inattivoMensile;
    }

    public void setInattivoMensile(double inattivoMensile) {
        this.inattivoMensile = inattivoMensile;
    }

    public double getTroppoVicinoMensile() {
        return troppoVicinoMensile;
    }

    public void setTroppoVicinoMensile(double troppoVicinoMensile) {
        this.troppoVicinoMensile = troppoVicinoMensile;
    }

    public double getTroppoLontanoMensile() {
        return troppoLontanoMensile;
    }

    public void setTroppoLontanoMensile(double troppoLontanoMensile) {
        this.troppoLontanoMensile = troppoLontanoMensile;
    }

    public int getNumeroPauseBreviMensili() {
        return numeroPauseBreviMensili;
    }

    public void setNumeroPauseBreviMensili(int numeroPauseBreviMensili) {
        this.numeroPauseBreviMensili = numeroPauseBreviMensili;
    }

    public int getNumeroPauseRiposoMensili() {
        return numeroPauseRiposoMensili;
    }

    public void setNumeroPauseRiposoMensili(int numeroPauseRiposoMensili) {
        this.numeroPauseRiposoMensili = numeroPauseRiposoMensili;
    }

    public LocalDate getMese() {
        return mese;
    }

    public void setMese(LocalDate mese) {
        this.mese = mese;
    }

    public Dipendente getDipendente() {
        return dipendente;
    }

    public void setDipendente(Dipendente dipendente) {
        this.dipendente = dipendente;
    }
}

