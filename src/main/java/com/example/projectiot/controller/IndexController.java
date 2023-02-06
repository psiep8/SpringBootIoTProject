package com.example.projectiot.controller;

import com.example.projectiot.dto.DatiUtente;
import com.example.projectiot.service.StatisticheGiornaliereService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class IndexController {

    private final StatisticheGiornaliereService statisticheGiornaliereService;

    public IndexController(StatisticheGiornaliereService statisticheGiornaliereService) {
        this.statisticheGiornaliereService = statisticheGiornaliereService;
    }

    @PostMapping(value = "/data-connection", consumes = "application/json")
    public void getDataFromArduino(@RequestBody DatiUtente postData) {
        System.out.println("è arrivato il" + postData );
        System.out.println("è arrivato il" + postData.getTroppoVicino() );

        statisticheGiornaliereService.getDatiAlMinuto(postData);

        //return postData;
    }
}
