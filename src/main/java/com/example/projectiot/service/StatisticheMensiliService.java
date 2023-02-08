package com.example.projectiot.service;

import com.example.projectiot.entity.StatisticheGiornaliere;
import com.example.projectiot.entity.StatisticheMensili;

import java.util.List;

public interface StatisticheMensiliService {
    List<StatisticheMensili> findAll();

}
