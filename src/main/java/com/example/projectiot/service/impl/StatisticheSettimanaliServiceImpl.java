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
    private final StatisticheGiornaliereRepository statisticheGiornaliereRepository;
    private final StatisticheMensiliRepository statisticheMensiliRepository;


    @Override
    public void findStatisticheGiornaliereByMeseAndSave(Integer month) {
        Integer numeroPauseBreviMensili = 0;
        Integer numeroPauseRiposoMensili = 0;
        Integer numeroAttivo = 0;
        Integer numeroInattivo = 0;
        Integer numeroVicino = 0;
        Integer numeroLontano = 0;
        StatisticheGiornaliere[] stats;
        int dayOfMonth = LocalDate.now().minusMonths(1).lengthOfMonth();
        if (LocalDate.now().getDayOfMonth() <= 5 && !statisticheMensiliRepository.findAllByMese(LocalDate.now().minusMonths(1).getMonth().toString())) {
            for (int i = 0; i < dayOfMonth; i++) {
                stats = statisticheGiornaliereRepository.getStatisticheGiornaliereByGiorno(LocalDate.now().minusDays(i + 1));
                for (StatisticheGiornaliere ss : stats) {
                    numeroAttivo += ss.getAttivoGiornaliero();
                    numeroPauseRiposoMensili += ss.getNumeroPauseRiposoGiornaliere();
                    numeroInattivo += ss.getInattivoGiornaliero();
                    numeroPauseBreviMensili += ss.getNumeroPauseBreviGiornaliere();
                    numeroLontano += ss.getTroppoLontanoGiornaliero();
                    numeroVicino += ss.getTroppoVicinoGiornaliero();
                }
            }
            StatisticheMensili statisticheMensili = StatisticheMensili.builder()
                    .mese(LocalDate.now().minusMonths(1).getMonth().name())
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


}
