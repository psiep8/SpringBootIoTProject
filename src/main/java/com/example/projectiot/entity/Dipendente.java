package com.example.projectiot.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

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

    public Dipendente(String nome, String cognome, String email, String ruolo, List<StatisticheGiornaliere> listStatisticheGiornaliere) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.ruolo = ruolo;
        this.listStatisticheGiornaliere = listStatisticheGiornaliere;
    }

    public Dipendente(long idDipendente, String nome, String cognome, String email, String ruolo, List<StatisticheGiornaliere> listStatisticheGiornaliere) {
        this.idDipendente = idDipendente;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.ruolo = ruolo;
        this.listStatisticheGiornaliere = listStatisticheGiornaliere;
    }

    public long getIdDipendente() {
        return idDipendente;
    }

    public void setIdDipendente(long idDipendente) {
        this.idDipendente = idDipendente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRuolo() {
        return ruolo;
    }

    public void setRuolo(String ruolo) {
        this.ruolo = ruolo;
    }

    public List<StatisticheGiornaliere> getListStatisticheGiornaliere() {
        return listStatisticheGiornaliere;
    }

    public void setListStatisticheGiornaliere(List<StatisticheGiornaliere> listStatisticheGiornaliere) {
        this.listStatisticheGiornaliere = listStatisticheGiornaliere;
    }

    public List<StatisticheSettimanali> getListStatisticheSettimanali() {
        return listStatisticheSettimanali;
    }

    public void setListStatisticheSettimanali(List<StatisticheSettimanali> listStatisticheSettimanali) {
        this.listStatisticheSettimanali = listStatisticheSettimanali;
    }

    public List<StatisticheMensili> getListStatisticheMensili() {
        return listStatisticheMensili;
    }

    public void setListStatisticheMensili(List<StatisticheMensili> listStatisticheMensili) {
        this.listStatisticheMensili = listStatisticheMensili;
    }
}

