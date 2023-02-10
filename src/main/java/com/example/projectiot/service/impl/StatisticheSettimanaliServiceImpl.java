package com.example.projectiot.service.impl;

import com.example.projectiot.dto.DatiPieDto;
import com.example.projectiot.entity.StatisticheGiornaliere;
import com.example.projectiot.entity.StatisticheMensili;
import com.example.projectiot.entity.StatisticheSettimanali;
import com.example.projectiot.repository.StatisticheGiornaliereRepository;
import com.example.projectiot.repository.StatisticheMensiliRepository;
import com.example.projectiot.repository.StatisticheSettimanaliRepository;
import com.example.projectiot.service.StatisticheGiornaliereService;
import com.example.projectiot.service.StatisticheSettimanaliService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StatisticheSettimanaliServiceImpl implements StatisticheSettimanaliService {
    private final StatisticheGiornaliereRepository statisticheGiornaliereRepository;
    private final StatisticheMensiliRepository statisticheMensiliRepository;
    private final StatisticheSettimanaliRepository statisticheSettimanaliRepository;


    @Override
    public List<StatisticheSettimanali> findAll() {
        return statisticheSettimanaliRepository.findAll();
    }

    @Override
    public StatisticheMensili findStatisticheGiornaliereByMeseAndSave() {
        Integer numeroPauseBreviMensili = 0;
        Integer numeroPauseRiposoMensili = 0;
        Integer numeroAttivo = 0;
        Integer numeroInattivo = 0;
        Integer numeroVicino = 0;
        Integer numeroLontano = 0;
        StatisticheGiornaliere[] stats;
        StatisticheMensili result = null;
        int dayOfMonth = LocalDate.now().minusMonths(1).lengthOfMonth();
        if (LocalDate.now().getDayOfMonth() <= 5 && statisticheMensiliRepository.countAllByMese(LocalDate.now().minusMonths(1).getMonth().toString()) == 0) {
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
            return StatisticheMensili.builder()
                    .mese(LocalDate.now().minusMonths(1).getMonth().name())
                    .numeroPauseBreviMensili(numeroPauseBreviMensili)
                    .numeroPauseRiposoMensili(numeroPauseRiposoMensili)
                    .attivoMensile(numeroAttivo)
                    .inattivoMensile(numeroInattivo)
                    .troppoVicinoMensile(numeroVicino)
                    .troppoLontanoMensile(numeroLontano)
                    .build();
        }
        return result;
    }

    @Override
    public void saveStatisticheMensili(StatisticheMensili statisticheMensili) {
        statisticheMensiliRepository.save(findStatisticheGiornaliereByMeseAndSave());
    }

    @Override
    public StatisticheSettimanali getStatSettimanaByGiorno(LocalDate giorno) {
        List<StatisticheSettimanali> listStats = findAll();
        for (StatisticheSettimanali ss : listStats) {
            if ((giorno.isAfter(ss.getDataInizio()) || giorno.isEqual(ss.getDataInizio())) && (giorno.isBefore(ss.getDataFine()) || giorno.isEqual(ss.getDataFine()))) {
                return ss;
            }
        }
        return null;
    }

    @Override
    public List<DatiPieDto> getStatsByWeek2(LocalDate giorno) {//pie

        StatisticheSettimanali statisticheSettimanali = getStatSettimanaByGiorno(giorno);
        List<DatiPieDto> risultato = new LinkedList<>();
        risultato.add(DatiPieDto.builder()
                .name("Attivo giornaliero")
                .value(statisticheSettimanali.getAttivoSettimanale())
                .build());
        risultato.add(DatiPieDto.builder()
                .value(statisticheSettimanali.getInattivoSettimanale())
                .name("Inattivo giornaliero")
                .build());
        risultato.add(DatiPieDto.builder()
                .value(statisticheSettimanali.getTroppoLontanoSettimanale())
                .name("Troppo lontano")
                .build());
        risultato.add(DatiPieDto.builder()
                .name("Troppo vicino")
                .value(statisticheSettimanali.getTroppoVicinoSettimanale())
                .build());

        return risultato;
    }
}
