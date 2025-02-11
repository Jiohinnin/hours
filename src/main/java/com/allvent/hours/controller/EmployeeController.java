package com.allvent.hours.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//import com.allvent.hours.model.employee.Employee;
import com.allvent.hours.model.employee.HourlyPaidEmployee;
import com.allvent.hours.model.employee.MonthlyPaidEmployee;
import com.allvent.hours.model.employee.POHPaidEmployee;
import com.allvent.hours.model.employee.SalaryType;
import com.allvent.hours.service.employee.EmployeeServiceImp;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@AllArgsConstructor
@Controller
@RequestMapping("/emp")

public class EmployeeController {
    
    EmployeeServiceImp service;
    //TODO Edit empl
    @GetMapping("/empType")
    public String setEmployeeType(Model model){
        model.addAttribute("slt", SalaryType.values());
        return "employee/empType";
    }
    

    @GetMapping("/empTypeEdit/{id}")
    public String setEDITEmployeeType(@PathVariable(required = false) Long id, Model model, RedirectAttributes rAttributes){
        System.out.println("\n" + id + "\n");
        if(id == null){
            model.addAttribute("slt", SalaryType.values());
            return "employee/empType";
        } else {
            rAttributes.addAttribute("id", id);
            model.addAttribute("slt", SalaryType.values());
            return "employee/empType";
        }
      
    }

    @PostMapping("/sbmtEmpType")
    public String submitEmployeeType(SalaryType slt, @RequestAttribute(required = false) Long id, RedirectAttributes rAttributes){
        System.out.println("\nFrom sbmtEmpType " + id + "\n\n\n\n");
        rAttributes.addAttribute("slt", slt);
        if(slt.equals(SalaryType.MONTHLY)){
            return "redirect:addMonthlyEmployee";
        } else if (slt.equals(SalaryType.HOURLY)){
            return "redirect:addHourlyEmployee";
        } else {
            return "redirect:addPOHEmployee";
        }
    }

    @GetMapping("/addMonthlyEmployee")
    public String addMonthlyEmployee(@RequestParam SalaryType slt, Model model){
        model.addAttribute("employee", new MonthlyPaidEmployee());
        return "employee/addMonthlyEmployee";
    }

    @PostMapping("/sbmtMonthlyEmployee")
    public String submitMonthlyEmployee(@Valid MonthlyPaidEmployee employee, BindingResult result){
        service.saveEmployee(employee);
        return "redirect:empType";
    }

    @GetMapping("/addHourlyEmployee")
    public String addHourlyEmployee(@RequestParam SalaryType slt, Model model) {
        model.addAttribute("employee", new HourlyPaidEmployee());
        return "employee/addHourlyEmployee";
    }
    
    @PostMapping("/sbmtHourlyEmployee")
    public String submitHourlyEmployee(@Valid HourlyPaidEmployee employee, BindingResult result){
        service.saveEmployee(employee);
        return "redirect:empType";
    }
    @GetMapping("/addPOHEmployee")
    public String addPOHEmployee(@RequestParam SalaryType slt, Model model) {
        model.addAttribute("employee", new POHPaidEmployee());
        return "employee/addPOHEmployee";
    }
    
    @PostMapping("/sbmtPOHEmployee")
    public String submitPOHEmployee(@Valid POHPaidEmployee employee, BindingResult result){
        service.saveEmployee(employee);
        return "redirect:empType";
    }

    @GetMapping("/showAllEmployeesAdmin")
    public String showAllEmployeesAdmin(Model model){
        model.addAttribute("employees", service.findAll());
        return "employee/all";
    }
    @GetMapping("/showAllEmployees")
    public String showAllEmployees(Model model ){
        model.addAttribute("employees", service.findAll());
        return "employee/employeeList";
    }


}
