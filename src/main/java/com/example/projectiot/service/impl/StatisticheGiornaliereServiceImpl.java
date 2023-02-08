package com.example.projectiot.service.impl;

import com.example.projectiot.dto.DatiUtente;
import com.example.projectiot.entity.StatisticheGiornaliere;
import com.example.projectiot.entity.StatisticheSettimanali;
import com.example.projectiot.repository.StatisticheGiornaliereRepository;
import com.example.projectiot.repository.StatisticheSettimanaliRepository;
import com.example.projectiot.service.StatisticheGiornaliereService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class StatisticheGiornaliereServiceImpl implements StatisticheGiornaliereService {
    private final StatisticheGiornaliereRepository statisticheGiornaliereRepository;
    private final StatisticheSettimanaliRepository statisticheSettimanaliRepository;

    @Override
    public void getDatiAlMinuto(DatiUtente datiUtenteMinuto) {
        StatisticheGiornaliere datiUtenteGiornaliero = StatisticheGiornaliere.builder()
                .numeroPauseRiposoGiornaliere(datiUtenteMinuto.getNumPauseLunghe())
                .numeroPauseBreviGiornaliere(datiUtenteMinuto.getNumPauseBrevi())
                .inattivoGiornaliero(datiUtenteMinuto.getTempoInattivo())
                .attivoGiornaliero(datiUtenteMinuto.getTempoAttivo())
                .troppoLontanoGiornaliero(datiUtenteMinuto.getTroppoLontano())
                .troppoVicinoGiornaliero(datiUtenteMinuto.getTroppoVicino())
                .giorno(LocalDate.now())
                .build();
        statisticheGiornaliereRepository.save(datiUtenteGiornaliero);

    }

    @Override
    public void countedStatistiche() {
        Integer numeroPauseBreviSettimanali = 0;
        Integer numeroPauseRiposoSettimanali = 0;
        Integer numeroAttivo = 0;
        Integer numeroInattivo = 0;
        Integer numeroVicino = 0;
        Integer numeroLontano = 0;
        StatisticheGiornaliere[] stats;
        if (LocalDate.now().getDayOfWeek().getValue() == 5) {
            for (int i = 0; i < 5; i++) {
                stats = statisticheGiornaliereRepository.getStatisticheGiornaliereByGiorno(LocalDate.now().minusDays(i));
                for (StatisticheGiornaliere ss : stats) {
                    numeroAttivo += ss.getAttivoGiornaliero();
                    numeroPauseRiposoSettimanali += ss.getNumeroPauseRiposoGiornaliere();
                    numeroInattivo += ss.getInattivoGiornaliero();
                    numeroPauseBreviSettimanali += ss.getNumeroPauseBreviGiornaliere();
                    numeroLontano += ss.getTroppoLontanoGiornaliero();
                    numeroVicino += ss.getTroppoVicinoGiornaliero();
                }
            }
        }
        StatisticheSettimanali statisticheSettimanali = StatisticheSettimanali.builder()
                .dataInizio(LocalDate.now().minusDays(4))
                .dataFine(LocalDate.now())
                .numeroPauseBreviSettimanali(numeroPauseBreviSettimanali)
                .numeroPauseRiposoSettimanali(numeroPauseRiposoSettimanali)
                .attivoSettimanale(numeroAttivo)
                .inattivoSettimanale(numeroInattivo)
                .troppoVicinoSettimanale(numeroVicino)
                .troppoLontanoSettimanale(numeroLontano)
                .build();
        statisticheSettimanaliRepository.save(statisticheSettimanali);

    }

}
