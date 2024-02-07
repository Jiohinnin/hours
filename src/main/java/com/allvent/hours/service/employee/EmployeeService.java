package com.allvent.hours.service.employee;

import java.util.List;

import com.allvent.hours.model.employee.Employee;

public interface EmployeeService {
    public List<Employee> findAll();
    public Employee getById(Long id);
    public void saveEmployee(Employee employee);
    public void deleteById(Long id);
}
