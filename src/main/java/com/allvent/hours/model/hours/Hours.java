package com.allvent.hours.model.hours;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.allvent.hours.model.employee.Employee;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "hours")
public class Hours {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "hours")
    @NotEmpty(message = "minimum value is 0")
    private double hours;

    @Column(name = "dayOfMonth")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @NotEmpty(message = "You can't add hours without date.")
    private LocalDate date;

    @ManyToOne(optional = false)
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;
    
    


}
