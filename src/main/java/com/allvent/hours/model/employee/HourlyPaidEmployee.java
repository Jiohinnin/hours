package com.allvent.hours.model.employee;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
@Entity
@DiscriminatorValue(value = "HOURLY")
public class HourlyPaidEmployee extends Employee{

    @Column(name = "rate", columnDefinition = "double default '0'", nullable = false)
    private double rate = 0;

    public HourlyPaidEmployee() {
        super(SalaryType.HOURLY);
    }
    
    public HourlyPaidEmployee(String name, String surname) {
        super(name, surname, SalaryType.HOURLY);
    }

    public HourlyPaidEmployee(String name, String surname, double rate) {
        super(name, surname, SalaryType.HOURLY);
        setRate(rate);
    }
  

    @Override
    public String toString() {
        return "{" +
            " id='" + super.getId() + "'" +
            ", salaryType='" + super.getSalaryType() + "'" +
            ", name='" + super.getName() + "'" +
            ", surname='" + super.getSurname() + "'" +
            ", bonus='" + super.getBonus() + "'" +
            ", hours='" + super.getHours() + "'" +
            " rate='" + getRate() + "'" +
            "}";
    }

   

    
}


