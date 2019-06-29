package com.example.employee.employeeservice.presentation.dto;


import com.example.employee.employeeservice.core.EmployeeRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeDTO {
    private String employeeName;
    private double employeeSalary;
    private EmployeeRole employeeRole;
}
