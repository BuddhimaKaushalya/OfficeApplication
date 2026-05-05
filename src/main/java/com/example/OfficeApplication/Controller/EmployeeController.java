package com.example.OfficeApplication.Controller;

import com.example.OfficeApplication.Entity.*;
import com.example.OfficeApplication.Service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee/v1")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    //  Only MANAGER
    @PostMapping("/developer")
    public Developer addDeveloper(@RequestBody Developer developer){
        return employeeService.addDeveloper(developer);
    }

    //  Only MANAGER
    @PostMapping("/manager")
    public Manager addManager(@RequestBody Manager manager){
        return employeeService.addManager(manager);
    }

    //  Any authenticated user
    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable Integer id){
        return employeeService.getEmployeeById(id);
    }

    // Only MANAGER
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id){
        employeeService.deleteEmployee(id);
        return "Deleted";
    }

    //  Salary
    @GetMapping("/{id}/salary")
    public double getSalary(@PathVariable Integer id){
        return employeeService.getSalaryById(id);
    }
}