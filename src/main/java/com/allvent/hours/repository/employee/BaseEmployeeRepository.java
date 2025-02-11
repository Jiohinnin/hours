package com.allvent.hours.repository.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.allvent.hours.model.employee.Employee;


@NoRepositoryBean
public interface BaseEmployeeRepository extends JpaRepository<Employee, Long>{
    
}
