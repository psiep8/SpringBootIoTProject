package com.example.projectiot.dto;

import lombok.Data;

@Data
public class DatiLineDto<T> {

    private String name;
    private DatiPieDto[] series;
}
