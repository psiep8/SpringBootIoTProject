package com.example.projectiot.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
@Builder
@Data
@Entity
@Table(name = "statistiche_mensili")
public class StatisticheMensili implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_statistiche_m")
    private long idStatisticheMensili;

    @Column(name = "attivo")
    private Integer attivoMensile;

    @Column(name = "inattivo")
    private Integer inattivoMensile;

    @Column(name = "troppo_vicino")
    private Integer troppoVicinoMensile;

    @Column(name = "troppo_lontano")
    private Integer troppoLontanoMensile;

    @Column(name = "num_pause_brevi")
    private Integer numeroPauseBreviMensili;

    @Column(name = "num_pause_riposo")
    private Integer numeroPauseRiposoMensili;

    @Column(name = "mese")
    private String mese;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dipendente_id")
    private Dipendente dipendente;

    public StatisticheMensili() {

    }

    public StatisticheMensili(long idStatisticheMensili, Integer attivoMensile, Integer inattivoMensile, Integer troppoVicinoMensile, Integer troppoLontanoMensile, Integer numeroPauseBreviMensili, Integer numeroPauseRiposoMensili, String mese, Dipendente dipendente) {
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

    public StatisticheMensili(Integer attivoMensile, Integer inattivoMensile, Integer troppoVicinoMensile, Integer troppoLontanoMensile, Integer numeroPauseBreviMensili, Integer numeroPauseRiposoMensili, String mese, Dipendente dipendente) {
        this.attivoMensile = attivoMensile;
        this.inattivoMensile = inattivoMensile;
        this.troppoVicinoMensile = troppoVicinoMensile;
        this.troppoLontanoMensile = troppoLontanoMensile;
        this.numeroPauseBreviMensili = numeroPauseBreviMensili;
        this.numeroPauseRiposoMensili = numeroPauseRiposoMensili;
        this.mese = mese;
        this.dipendente = dipendente;
    }
}

