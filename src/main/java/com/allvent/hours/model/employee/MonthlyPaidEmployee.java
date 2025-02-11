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
@DiscriminatorValue(value = "MONTHLY")
public class MonthlyPaidEmployee extends Employee{
//columnDefinition = "double default '0'"
    @Column(name = "advance", columnDefinition = "double default '0'", nullable = false)
    private double advance = 0;

    public MonthlyPaidEmployee() {
        super(SalaryType.MONTHLY);
    }

    public MonthlyPaidEmployee(String name, String surname) {
        super(name, surname, SalaryType.MONTHLY);
        
    }

    public MonthlyPaidEmployee(String name, String surname, double advance) {
        super(name, surname, SalaryType.MONTHLY);
        setAdvance(advance);
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
            " advance='" + getAdvance() + "'" +
            "}";
    }
}


