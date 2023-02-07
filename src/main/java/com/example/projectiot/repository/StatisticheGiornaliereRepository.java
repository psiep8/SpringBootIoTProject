package com.example.projectiot.repository;

import com.example.projectiot.entity.StatisticheGiornaliere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface StatisticheGiornaliereRepository extends JpaRepository<StatisticheGiornaliere, Long> {

    StatisticheGiornaliere[] getStatisticheGiornaliereByGiorno(LocalDate giorno);

}
