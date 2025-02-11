package com.allvent.hours.service.employee;

import java.util.List;

import org.springframework.stereotype.Service;

import com.allvent.hours.model.employee.Employee;

@Service
public interface BaseEmployeeService{
    public List<Employee> findAll();
    public Employee findById(Long id);
    public void saveEmployee(Employee employee);
    public void deleteById(Long id);
}
