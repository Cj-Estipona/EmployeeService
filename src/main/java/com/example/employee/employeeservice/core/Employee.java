package com.example.employee.employeeservice.core;


import com.example.employee.employeeservice.infrastructure.entity.EmployeeRoleEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Employee {
    private Long employeeID;
    private String employeeName;
    private double employeeSalary;
    private EmployeeRole employeeRole;
}
