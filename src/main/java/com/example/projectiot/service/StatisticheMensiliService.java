package com.example.projectiot.service;

import com.example.projectiot.dto.DatiPieDto;
import com.example.projectiot.entity.StatisticheGiornaliere;
import com.example.projectiot.entity.StatisticheMensili;

import java.util.List;

public interface StatisticheMensiliService {
    List<StatisticheMensili> findAll();

    StatisticheMensili getStatsByMese(String mese);

    List<DatiPieDto> getStatsByMonth2(String mese);
}
