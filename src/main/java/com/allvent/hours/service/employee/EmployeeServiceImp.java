package com.allvent.hours.service.employee;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.allvent.hours.model.employee.Employee;
import com.allvent.hours.repository.employee.BaseEmployeeRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImp implements BaseEmployeeService{

    private BaseEmployeeRepository repository;

    @Override
    public List<Employee> findAll() {
        return repository.findAll();
    }

    @Override
    public Employee findById(Long id) {
        if (id == null) throw new NullPointerException();
        Optional<Employee> employee = repository.findById(id);
        if(employee.isPresent()){
            return employee.get();
        } else {
            throw new NoSuchElementException("There is no Employee at id: " + id);
        }
        
    }

    @Override
    public void saveEmployee(Employee employee) {
        if(employee != null){
            repository.save(employee);
        } else {
            throw new IllegalArgumentException("Try again something is not working");
        }
    }

    @Override
    public void deleteById(Long id) {
        if(id != null){
            repository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Try again something is not working");
        }
    }

        
    
}
