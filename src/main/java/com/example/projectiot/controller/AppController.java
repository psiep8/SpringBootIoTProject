package com.example.projectiot.controller;

import com.example.projectiot.dto.DatiUtente;
import com.example.projectiot.service.StatisticheGiornaliereService;
import com.example.projectiot.service.StatisticheSettimanaliService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@CrossOrigin("*")
public class AppController {

    private final StatisticheGiornaliereService statisticheGiornaliereService;
    private final StatisticheSettimanaliService statisticheSettimanaliService;

    public AppController(StatisticheGiornaliereService statisticheGiornaliereService, StatisticheSettimanaliService statisticheSettimanaliService) {
        this.statisticheGiornaliereService = statisticheGiornaliereService;
        this.statisticheSettimanaliService = statisticheSettimanaliService;
    }

    @PostMapping(value = "/data-connection", consumes = "application/json")
    public void getDataFromArduino(@RequestBody DatiUtente postData) {
        statisticheGiornaliereService.getDatiAlMinuto(postData);
    }

    @GetMapping(value = "/statistiche-mensili")
    public void getStatisticheMensili() {
        statisticheSettimanaliService.findStatisticheGiornaliereByMeseAndSave(LocalDate.now().getMonth().getValue());
    }

    @GetMapping(value = "/statistiche-settimanali")
    public void getStatisticheSettimanali() {
        statisticheGiornaliereService.countedStatistiche();
    }
}
