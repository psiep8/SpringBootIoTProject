package com.example.projectiot.service.impl;


import com.example.projectiot.dto.DatiPieDto;
import com.example.projectiot.entity.StatisticheMensili;
import com.example.projectiot.repository.StatisticheMensiliRepository;
import com.example.projectiot.service.StatisticheMensiliService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StatisticheMensiliServiceImpl implements StatisticheMensiliService {

    private final StatisticheMensiliRepository statisticheMensiliRepository;

    @Override
    public List<StatisticheMensili> findAll() {
        return statisticheMensiliRepository.findAll();
    }

    public StatisticheMensili getStatsByMese(String mese) {
        return statisticheMensiliRepository.getStatisticheMensiliByMese(mese);
    }

    @Override
    public List<DatiPieDto> getStatsByMonth2(String mese) {//pie

        StatisticheMensili statisticheMensili = getStatsByMese(mese);
        List<DatiPieDto> risultato = new LinkedList<>();
        risultato.add(DatiPieDto.builder()
                .name("Attivo giornaliero")
                .value(statisticheMensili.getAttivoMensile())
                .build());
        risultato.add(DatiPieDto.builder()
                .value(statisticheMensili.getInattivoMensile())
                .name("Inattivo giornaliero")
                .build());
        risultato.add(DatiPieDto.builder()
                .value(statisticheMensili.getTroppoLontanoMensile())
                .name("Troppo lontano")
                .build());
        risultato.add(DatiPieDto.builder()
                .name("Troppo vicino")
                .value(statisticheMensili.getTroppoVicinoMensile())
                .build());

        return risultato;
    }
}
