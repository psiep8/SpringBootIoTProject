package com.example.projectiot.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
@Builder
@Data
@RequiredArgsConstructor
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
    private Integer numeroPauseBreviGiornaliere;

    @Column(name = "num_pause_riposo")
    private Integer numeroPauseRiposoGiornaliere;

    @Column(name = "giorno")
    private LocalDate giorno;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dipendente_id")
    private Dipendente dipendente;

}

