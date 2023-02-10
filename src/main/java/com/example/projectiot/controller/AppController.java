package com.example.projectiot.controller;

import com.example.projectiot.dto.DatiPieDto;
import com.example.projectiot.dto.DatiUtente;
import com.example.projectiot.entity.StatisticheGiornaliere;
import com.example.projectiot.entity.StatisticheMensili;
import com.example.projectiot.entity.StatisticheSettimanali;
import com.example.projectiot.service.StatisticheGiornaliereService;
import com.example.projectiot.service.StatisticheMensiliService;
import com.example.projectiot.service.StatisticheSettimanaliService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class AppController {
    private final StatisticheGiornaliereService statisticheGiornaliereService;
    private final StatisticheSettimanaliService statisticheSettimanaliService;
    private final StatisticheMensiliService statisticheMensiliService;

    @PostMapping(value = "/data-connection", consumes = "application/json")
    public void getDataFromArduino(@RequestBody DatiUtente postData) {
        statisticheGiornaliereService.getDatiOgniOra(postData);
    }

    @GetMapping(value = "/statistiche-giornaliere")
    public List<StatisticheGiornaliere> statisticheGiornaliere() {
        return statisticheGiornaliereService.findAll();
    }


    @GetMapping(value = "/statistiche-settimanali")
    public List<StatisticheSettimanali> statisticheSettimanali() {
        return statisticheSettimanaliService.findAll();
    }

    @GetMapping(value = "/statistiche-mensili")
    public List<StatisticheMensili> statisticheMensili() {
        return statisticheMensiliService.findAll();
    }

    @GetMapping(value = "/statistiche-giornaliere-date")
    public List<StatisticheGiornaliere> getStatisticheGiornaliereByDay(@RequestParam("giorno") LocalDate giorno) {
        return statisticheGiornaliereService.getStatsByDay(giorno);
    }

    @GetMapping(value = "/statistica-settimanale-date")
    public StatisticheSettimanali getStatisticaSettimanaleByDay(@RequestParam("giorno") LocalDate giorno) {
        return statisticheSettimanaliService.getStatSettimanaByGiorno(giorno);
    }

    @GetMapping(value = "/statistica-mensile-date")
    public StatisticheMensili getStatisticaMensileByMese(@RequestParam("mese") String mese) {
        return statisticheMensiliService.getStatsByMese(mese);
    }

    @GetMapping(value = "/stat-mensile")
    public StatisticheMensili countedStatisticheMensili() {
        return statisticheSettimanaliService.findStatisticheGiornaliereByMeseAndSave();
    }

    @GetMapping(value = "/stat-settimanale")
    public StatisticheSettimanali countedStatisticheSettimanali() {
        return statisticheGiornaliereService.countedStatistiche();
    }

    @PostMapping(value = "/save-statistiche-mensili")
    public void saveStatisticheMensili(@RequestBody StatisticheMensili statisticheMensili) {
        statisticheSettimanaliService.saveStatisticheMensili(statisticheMensili);
    }

    @PostMapping(value = "/save-statistiche-settimanali")
    public void saveStatisticheSettimanali(@RequestBody StatisticheSettimanali statisticheSettimanali) {
        statisticheGiornaliereService.saveStatisticheSettimanali(statisticheSettimanali);
    }
/////////////////////////////////////////////////
    @GetMapping(value = "/statistiche-giornaliere-date-prova")
    public List<DatiPieDto> getStatisticheGiornaliereByDay2(@RequestParam("giorno") LocalDate giorno) {
        return statisticheGiornaliereService.getStatsByDay2(giorno);
    }
}
