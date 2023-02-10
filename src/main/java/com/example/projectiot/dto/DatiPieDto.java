package com.example.projectiot.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class DatiPieDto {
    private String name;
    private int value;
    private int value2;
}
