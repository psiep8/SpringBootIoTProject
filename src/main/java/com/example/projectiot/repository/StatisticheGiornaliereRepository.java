package com.example.projectiot.repository;

import com.example.projectiot.entity.StatisticheGiornaliere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface StatisticheGiornaliereRepository extends JpaRepository<StatisticheGiornaliere, Long> {

    StatisticheGiornaliere[] getStatisticheGiornaliereByGiorno(LocalDate giorno);

    List<StatisticheGiornaliere> findStatisticheGiornaliereByGiorno(LocalDate giorno);


}
