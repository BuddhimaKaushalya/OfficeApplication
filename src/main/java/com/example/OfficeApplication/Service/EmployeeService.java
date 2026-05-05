package com.example.OfficeApplication.Service;

import com.example.OfficeApplication.Entity.Developer;
import com.example.OfficeApplication.Entity.Employee;
import com.example.OfficeApplication.Entity.Manager;
import com.example.OfficeApplication.Repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    public Developer addDeveloper(Developer developer){
        return employeeRepository.save(developer);
    }

    public Manager addManager(Manager manager){
        return employeeRepository.save(manager);
    }

    public Employee getEmployeeById(Integer id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
    }

    public void deleteEmployee(Integer id) {
        if (!employeeRepository.existsById(id)) {
            throw new RuntimeException("Employee not found with id: " + id);
        }
        employeeRepository.deleteById(id);
    }

    public double getSalaryById(Integer id) {
        Employee emp = getEmployeeById(id);
        return emp.calculateSalary();
    }
}