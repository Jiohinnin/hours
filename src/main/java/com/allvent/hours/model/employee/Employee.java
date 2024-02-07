package com.allvent.hours.model.employee;



import java.util.List;

import com.allvent.hours.constans.SalaryType;
import com.allvent.hours.model.hours.Hours;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "employee")
public  class Employee {
     
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    @NotBlank (message = "Name cannot be blank!!!")
    @NotEmpty (message = "Name cannot be empty!!!")
    private String name;

    @Column(name = "surname", nullable = false)
    @NotBlank (message = "Surname cannot be blank!!!")
    @NotEmpty (message = "Surname cannot be empty!!!")
    private String surname;

    @Column(name = "salary-type", nullable = false)
    private SalaryType salaryType;

    @Column(name = "rate", nullable = false)
    private double rate;

    @Column(name = "advance", nullable = false)
    private double advance;

    @Column(name = "bonus", nullable = false)
    private double bonus = 0;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Hours> hours;

    public Employee(){

    }

    public Employee(String name, String surname, SalaryType salaryType, double rate, double advance) {
        setName(name);
        setSurname(surname);
        setSalaryType(salaryType);
        setRate(rate);
        setAdvance(advance);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", surname='" + getSurname() + "'" +
            ", salaryType='" + getSalaryType() + "'" +
            ", rate='" + getRate() + "'" +
            ", advance='" + getAdvance() + "'" +
            ", bonus='" + getBonus() + "'" +
            ", hours='" + getHours() + "'" +
            "}";
    }
}

    
