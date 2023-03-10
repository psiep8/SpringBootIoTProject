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
@Table(name = "statistiche_settimanali")
public class StatisticheSettimanali implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_statistiche_s")
    private long idStatisticheSettimanali;

    @Column(name = "attivo")
    private Integer attivoSettimanale;

    @Column(name = "inattivo")
    private Integer inattivoSettimanale;

    @Column(name = "troppo_vicino")
    private Integer troppoVicinoSettimanale;

    @Column(name = "troppo_lontano")
    private Integer troppoLontanoSettimanale;

    @Column(name = "num_pause_brevi")
    private Integer numeroPauseBreviSettimanali;

    @Column(name = "num_pause_riposo")
    private Integer numeroPauseRiposoSettimanali;

    @Column(name = "data_inizio")
    private LocalDate dataInizio;

    @Column(name = "data_fine")
    private LocalDate dataFine;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dipendente_id")
    private Dipendente dipendente;

    public StatisticheSettimanali() {

    }

    public StatisticheSettimanali(long idStatisticheSettimanali, Integer attivoSettimanale, Integer inattivoSettimanale, Integer troppoVicinoSettimanale, Integer troppoLontanoSettimanale, Integer numeroPauseBreviSettimanali, Integer numeroPauseRiposoSettimanali, LocalDate dataInizio, LocalDate dataFine, Dipendente dipendente) {
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

    public StatisticheSettimanali(Integer attivoSettimanale, Integer inattivoSettimanale, Integer troppoVicinoSettimanale, Integer troppoLontanoSettimanale, Integer numeroPauseBreviSettimanali, Integer numeroPauseRiposoSettimanali, LocalDate dataInizio, LocalDate dataFine, Dipendente dipendente) {
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
}

