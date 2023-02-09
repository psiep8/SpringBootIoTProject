package com.example.projectiot.service;

import com.example.projectiot.entity.StatisticheGiornaliere;
import com.example.projectiot.entity.StatisticheMensili;
import com.example.projectiot.entity.StatisticheSettimanali;

import java.time.LocalDate;
import java.util.List;

public interface StatisticheSettimanaliService {
    List<StatisticheSettimanali> findAll();

    StatisticheMensili findStatisticheGiornaliereByMeseAndSave();

    void saveStatisticheMensili(StatisticheMensili statisticheMensili);

    StatisticheSettimanali getStatSettimanaByGiorno(LocalDate giorno);

}
