package com.example.projectiot.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.List;
@Builder
@Data
@RequiredArgsConstructor
@Entity
@Table(name = "dipendente")
public class Dipendente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_dipendente")
    private long idDipendente;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cognome")
    private String cognome;

    @Column(name = "email")
    private String email;

    @Column(name = "ruolo")
    private String ruolo;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "dipendente")
    private List<StatisticheGiornaliere> listStatisticheGiornaliere;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "dipendente")
    private List<StatisticheSettimanali> listStatisticheSettimanali;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "dipendente")
    private List<StatisticheMensili> listStatisticheMensili;

}

