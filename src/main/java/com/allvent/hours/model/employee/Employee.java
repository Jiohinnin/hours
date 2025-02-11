package com.allvent.hours.model.employee;



import java.util.List;


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
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
    name = "SALARY_TYPE",
    discriminatorType = DiscriminatorType.STRING
)
public abstract class Employee {
     
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "salary-type", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private SalaryType salaryType;

    @Column(name = "name", nullable = false)
    @NotBlank (message = "Name cannot be blank!!!")
    @NotEmpty (message = "Name cannot be empty!!!")
    private String name;

    @Column(name = "surname", nullable = false)
    @NotBlank (message = "Surname cannot be blank!!!")
    @NotEmpty (message = "Surname cannot be empty!!!")
    private String surname;

    @Column(name = "bonus", nullable = false)
    private double bonus = 0;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Hours> hours;

    public Employee(){

    }

    public Employee(SalaryType salaryType){
        setSalaryType(salaryType);
    }

    public Employee(String name, String surname, SalaryType salaryType) {
        setName(name);
        setSurname(surname);
        setSalaryType(salaryType);
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", salaryType='" + getSalaryType() + "'" +
            ", name='" + getName() + "'" +
            ", surname='" + getSurname() + "'" +
            ", bonus='" + getBonus() + "'" +
            ", hours='" + getHours() + "'" +
            "}";
    }
    
}

    
