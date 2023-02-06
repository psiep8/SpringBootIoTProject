package com.example.projectiot.service.impl;

import com.example.projectiot.dto.DatiUtente;
import com.example.projectiot.entity.StatisticheGiornaliere;
import com.example.projectiot.repository.StatisticheGiornaliereRepository;
import com.example.projectiot.service.StatisticheGiornaliereService;
import org.springframework.stereotype.Service;

@Service
public class StatisticheGiornaliereServiceImpl implements StatisticheGiornaliereService {
    private final StatisticheGiornaliereRepository statisticheGiornaliereRepository;

    public StatisticheGiornaliereServiceImpl(StatisticheGiornaliereRepository statisticheGiornaliereRepository) {
        this.statisticheGiornaliereRepository = statisticheGiornaliereRepository;
    }

    @Override
    public void getDatiAlMinuto(DatiUtente datiUtenteMinuto) {

        StatisticheGiornaliere datiUtenteGiornaliero = StatisticheGiornaliere.builder()
                .numeroPauseRiposoGiornaliere(datiUtenteMinuto.getNumPauseLunghe())
                .numeroPauseBreviGiornaliere(datiUtenteMinuto.getNumPauseBrevi())
                .inattivoGiornaliero(datiUtenteMinuto.getTempoInattivo())
                .attivoGiornaliero(datiUtenteMinuto.getTempoAttivo())
                .troppoLontanoGiornaliero(datiUtenteMinuto.getTroppoLontano())
                .troppoVicinoGiornaliero(datiUtenteMinuto.getTroppoVicino())
                .build();

        statisticheGiornaliereRepository.save(datiUtenteGiornaliero);
    }
}
