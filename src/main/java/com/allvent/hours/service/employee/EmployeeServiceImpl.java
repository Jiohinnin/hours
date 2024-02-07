package com.allvent.hours.service.employee;

import java.util.List;

import org.springframework.stereotype.Service;

import com.allvent.hours.model.employee.Employee;
import com.allvent.hours.repository.EmployeeRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    
    private final EmployeeRepository repository;

    public List<Employee> findAll(){
        return repository.findAll();
    }
    
    public Employee getById(Long id){
        if(id == null) throw new IllegalArgumentException();    
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Employee doesn't exist."));
    }

    public void saveEmployee(Employee employee){
        if(employee != null){
            repository.save(employee);
        }
    }

    public void deleteById(Long id){
        if(id != null) repository.deleteById(id);
    }
}
