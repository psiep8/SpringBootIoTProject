package com.example.projectiot.repository;

import com.example.projectiot.entity.StatisticheMensili;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatisticheMensiliRepository extends JpaRepository<StatisticheMensili, Long> {
    Integer countAllByMese(String mese);

    StatisticheMensili getStatisticheMensiliByMese(String mese);
}
