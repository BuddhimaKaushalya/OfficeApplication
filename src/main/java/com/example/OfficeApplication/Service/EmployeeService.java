package com.example.OfficeApplication.Service;

import com.example.OfficeApplication.Entity.*;
import com.example.OfficeApplication.Repository.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    public Developer addDeveloper(Developer developer){
        return employeeRepository.save(developer);
    }

    public Manager addManager(Manager manager){
        return employeeRepository.save(manager);
    }

    public Employee getEmployeeById(Integer id){
        return employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found"));
    }

    public void deleteEmployee(Integer id){
        employeeRepository.deleteById(id);
    }

    public double getSalaryById(Integer id){
        return getEmployeeById(id).calculateSalary();
    }
}