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
import java.util.List;

@Service
@RequiredArgsConstructor
public class StatisticheGiornaliereServiceImpl implements StatisticheGiornaliereService {
    private final StatisticheGiornaliereRepository statisticheGiornaliereRepository;
    private final StatisticheSettimanaliRepository statisticheSettimanaliRepository;

    @Override
    public void getDatiOgniOra(DatiUtente datiUtenteOra) {
        StatisticheGiornaliere datiUtenteGiornaliero = StatisticheGiornaliere.builder()
                .numeroPauseRiposoGiornaliere(datiUtenteOra.getNumPauseLunghe())
                .numeroPauseBreviGiornaliere(datiUtenteOra.getNumPauseBrevi())
                .inattivoGiornaliero(datiUtenteOra.getTempoInattivo())
                .attivoGiornaliero(datiUtenteOra.getTempoAttivo())
                .troppoLontanoGiornaliero(datiUtenteOra.getTroppoLontano())
                .troppoVicinoGiornaliero(datiUtenteOra.getTroppoVicino())
                .giorno(LocalDate.now())
                .ora(datiUtenteOra.getOra())
                .build();
        statisticheGiornaliereRepository.save(datiUtenteGiornaliero);

    }

    @Override
    public StatisticheSettimanali countedStatistiche() {
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
        return StatisticheSettimanali.builder()
                .dataInizio(LocalDate.now().minusDays(4))
                .dataFine(LocalDate.now())
                .numeroPauseBreviSettimanali(numeroPauseBreviSettimanali)
                .numeroPauseRiposoSettimanali(numeroPauseRiposoSettimanali)
                .attivoSettimanale(numeroAttivo)
                .inattivoSettimanale(numeroInattivo)
                .troppoVicinoSettimanale(numeroVicino)
                .troppoLontanoSettimanale(numeroLontano)
                .build();

    }

    @Override
    public List<StatisticheGiornaliere> findAll() {
        return statisticheGiornaliereRepository.findAll();
    }

    @Override
    public void saveStatisticheSettimanali(StatisticheSettimanali statisticheSettimanali) {
        statisticheSettimanaliRepository.save(countedStatistiche());
    }

}
