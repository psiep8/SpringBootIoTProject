package com.example.projectiot.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.List;
@Builder
@Data
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

    public Dipendente() {
    }

    public Dipendente(long idDipendente, String nome, String cognome, String email, String ruolo, List<StatisticheGiornaliere> listStatisticheGiornaliere, List<StatisticheSettimanali> listStatisticheSettimanali, List<StatisticheMensili> listStatisticheMensili) {
        this.idDipendente = idDipendente;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.ruolo = ruolo;
        this.listStatisticheGiornaliere = listStatisticheGiornaliere;
        this.listStatisticheSettimanali = listStatisticheSettimanali;
        this.listStatisticheMensili = listStatisticheMensili;
    }

    public Dipendente(String nome, String cognome, String email, String ruolo, List<StatisticheGiornaliere> listStatisticheGiornaliere, List<StatisticheSettimanali> listStatisticheSettimanali, List<StatisticheMensili> listStatisticheMensili) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.ruolo = ruolo;
        this.listStatisticheGiornaliere = listStatisticheGiornaliere;
        this.listStatisticheSettimanali = listStatisticheSettimanali;
        this.listStatisticheMensili = listStatisticheMensili;
    }
}

