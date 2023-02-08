package com.example.projectiot.service;

import com.example.projectiot.dto.DatiUtente;
import com.example.projectiot.entity.StatisticheGiornaliere;
import com.example.projectiot.entity.StatisticheSettimanali;

import java.util.List;

public interface StatisticheGiornaliereService {

    void getDatiOgniOra(DatiUtente du);

    StatisticheSettimanali countedStatistiche();

    List<StatisticheGiornaliere> findAll();

    void saveStatisticheSettimanali(StatisticheSettimanali statisticheSettimanali);

}
