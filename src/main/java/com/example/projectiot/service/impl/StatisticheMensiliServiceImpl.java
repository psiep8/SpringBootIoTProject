package com.example.projectiot.service.impl;


import com.example.projectiot.entity.StatisticheGiornaliere;
import com.example.projectiot.entity.StatisticheMensili;
import com.example.projectiot.repository.StatisticheMensiliRepository;
import com.example.projectiot.service.StatisticheMensiliService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
}
