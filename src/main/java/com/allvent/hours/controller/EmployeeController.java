package com.allvent.hours.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;

import com.allvent.hours.model.employee.Employee;
import com.allvent.hours.service.employee.EmployeeServiceImpl;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@AllArgsConstructor
public class EmployeeController {
    
    EmployeeServiceImpl service;

    @GetMapping("/addEmployee")
    public String addEmployeeFrom(Model model, @RequestParam(required = false) Long id){
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "addEmployee";
    }

    @PostMapping("/submitEmployee")
    public String submitEmployee(@Valid Employee employee, BindingResult result, RedirectAttributes redirectAttributes){
        if(result.hasErrors()){
            return "addEmployee";
        }
        service.saveEmployee(employee);
        redirectAttributes.addFlashAttribute("success", "Pomyślnie dodano pracownika.");

        return "redirect:addEmployee";
    }

}
