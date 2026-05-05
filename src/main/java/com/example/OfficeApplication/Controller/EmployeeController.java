package com.example.OfficeApplication.Controller;

import com.example.OfficeApplication.Entity.Developer;
import com.example.OfficeApplication.Entity.Employee;
import com.example.OfficeApplication.Entity.Manager;
import com.example.OfficeApplication.Service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee/v1")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @PostMapping("/developer")
    public ResponseEntity<Developer> addDeveloper(@RequestBody Developer developer){
        Developer saved = employeeService.addDeveloper(developer);
        return ResponseEntity.status(201).body(saved);
    }

    @PostMapping("/manager")
    public ResponseEntity<Manager> addManager(@RequestBody Manager manager){
        Manager saved = employeeService.addManager(manager);
        return ResponseEntity.status(201).body(saved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer id){
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

    @GetMapping("/{id}/salary")
    public ResponseEntity<Double> getSalary(@PathVariable Integer id){
        return ResponseEntity.ok(employeeService.getSalaryById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Integer id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok("Employee deleted successfully");
    }
}