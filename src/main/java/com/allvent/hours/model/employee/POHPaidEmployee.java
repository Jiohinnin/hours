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
@DiscriminatorValue(value = "HOURLY_AND_PER_ORDER")
public class POHPaidEmployee extends Employee{

    @Column(name = "rate", columnDefinition = "double default '0'", nullable = false)
    private double rate = 0;

    public POHPaidEmployee() {
        super(SalaryType.HOURLY_AND_PER_ORDER);
    }
    
    public POHPaidEmployee(String name, String surname ) {
        super(name, surname, SalaryType.HOURLY_AND_PER_ORDER);
    } 
    public POHPaidEmployee(String name, String surname, double rate) {
        super(name, surname, SalaryType.HOURLY_AND_PER_ORDER);
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


