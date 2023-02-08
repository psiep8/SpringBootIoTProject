package com.example.projectiot.repository;

import com.example.projectiot.entity.StatisticheMensili;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatisticheMensiliRepository extends JpaRepository<StatisticheMensili, Long> {
    Boolean findAllByMese(String mese);
}
