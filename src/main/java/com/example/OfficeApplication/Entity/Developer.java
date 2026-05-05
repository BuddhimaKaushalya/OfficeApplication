package com.example.OfficeApplication.Entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Developer extends Employee {

    private double monthlySalary;

    @Override
    public double calculateSalary() {
        return monthlySalary;
    }
}