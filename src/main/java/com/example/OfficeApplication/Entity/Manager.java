package com.example.OfficeApplication.Entity;

import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Manager extends Employee {

    private double monthlySalary;
    private double bonus;

    @Override
    public double calculateSalary() {
        return monthlySalary + bonus;
    }
}