package com.example.projectiot.service.impl;

import com.example.projectiot.entity.StatisticheGiornaliere;
import com.example.projectiot.entity.StatisticheMensili;
import com.example.projectiot.entity.StatisticheSettimanali;
import com.example.projectiot.repository.StatisticheGiornaliereRepository;
import com.example.projectiot.repository.StatisticheMensiliRepository;
import com.example.projectiot.repository.StatisticheSettimanaliRepository;
import com.example.projectiot.service.StatisticheMensiliService;
import com.example.projectiot.service.StatisticheSettimanaliService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class StatisticheSettimanaliServiceImpl implements StatisticheSettimanaliService {
    private final StatisticheSettimanaliRepository statisticheSettimanaliRepository;
    private final StatisticheGiornaliereRepository statisticheGiornaliereRepository;
    private final StatisticheMensiliRepository statisticheMensiliRepository;

    @Override
    public void findStatisticheGiornaliereByMeseAndSave(Integer month) {

    }
/*
    @Override
    public void findStatisticheGiornaliereByMeseAndSave(Integer month) {
        Integer numeroPauseBreviMensili = 0;
        Integer numeroPauseRiposoMensili = 0;
        Integer numeroAttivo = 0;
        Integer numeroInattivo = 0;
        Integer numeroVicino = 0;
        Integer numeroLontano = 0;
        Integer dayOfMonth = LocalDate.now().minusMonths(1).lengthOfMonth();
        StatisticheGiornaliere[] stats = new StatisticheGiornaliere[dayOfMonth];
        if (LocalDate.now().getDayOfMonth() == 7) {
            for (int i = 0; i < dayOfMonth; i++) {
                stats[i] = statisticheGiornaliereRepository.getStatisticheGiornaliereByGiorno(LocalDate.now().minusDays(i + 1));
            }
            for (int j = 0; j < dayOfMonth; j++) {
                numeroPauseBreviMensili += stats[j].getNumeroPauseBreviGiornaliere();
                numeroPauseRiposoMensili += stats[j].getNumeroPauseRiposoGiornaliere();
                numeroInattivo += stats[j].getInattivoGiornaliero();
                numeroAttivo += stats[j].getAttivoGiornaliero();
                numeroLontano += stats[j].getTroppoLontanoGiornaliero();
                numeroVicino += stats[j].getTroppoVicinoGiornaliero();
            }
            StatisticheMensili statisticheMensili = StatisticheMensili.builder()
                    .mese(LocalDate.now().minusMonths(1).getMonth().toString())
                    .numeroPauseBreviMensili(numeroPauseBreviMensili)
                    .numeroPauseRiposoMensili(numeroPauseRiposoMensili)
                    .attivoMensile(numeroAttivo)
                    .inattivoMensile(numeroInattivo)
                    .troppoVicinoMensile(numeroVicino)
                    .troppoLontanoMensile(numeroLontano)
                    .build();
            statisticheMensiliRepository.save(statisticheMensili);
        }
    }

*/
}
