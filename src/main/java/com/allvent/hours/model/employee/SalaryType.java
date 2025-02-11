package com.allvent.hours.model.employee;

import lombok.Getter;

@Getter
public enum SalaryType {

    HOURLY ("Godzinowe"),
    MONTHLY("Miesięczne"),
    HOURLY_AND_PER_ORDER ("Godzinowe plus akord");

    private final String name;

    SalaryType(String name){
        this.name = name;
    }
}
