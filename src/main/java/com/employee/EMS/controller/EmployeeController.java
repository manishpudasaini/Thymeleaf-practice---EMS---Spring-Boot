package com.employee.EMS.controller;

import com.employee.EMS.entity.Employee;
import com.employee.EMS.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/home")
    public String homePage(Model model){
       List<Employee> employeeList =  employeeService.getEmployee();
       model.addAttribute("employee",employeeList);
        System.out.println(employeeList);
        return "home";
    }

    @GetMapping("/add")
    public String addEmployee(){
        return "addEmployee";
    }

    @PostMapping("/empAdd")
    public String empAdded(@ModelAttribute Employee employee){
        employeeService.addEmployee(employee);
        return "redirect:/home";
    }

}
