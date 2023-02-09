package com.example.projectiot.repository;

import com.example.projectiot.entity.StatisticheGiornaliere;
import com.example.projectiot.entity.StatisticheMensili;
import com.example.projectiot.entity.StatisticheSettimanali;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface StatisticheSettimanaliRepository extends JpaRepository<StatisticheSettimanali, Long> {



}
