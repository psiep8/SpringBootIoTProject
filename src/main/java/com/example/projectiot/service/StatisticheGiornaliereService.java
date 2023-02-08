package com.example.projectiot.service;

import com.example.projectiot.dto.DatiUtente;
import com.example.projectiot.entity.StatisticheGiornaliere;

import java.time.LocalDate;

public interface StatisticheGiornaliereService {

    void getDatiAlMinuto(DatiUtente du);

    void countedStatistiche();


}
