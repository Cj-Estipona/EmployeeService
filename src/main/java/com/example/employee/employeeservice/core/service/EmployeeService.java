package com.example.employee.employeeservice.core.service;

import com.example.employee.employeeservice.core.Employee;
import com.example.employee.employeeservice.presentation.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployeesWithRole();
    Employee createNewEmployee(EmployeeDTO newEmployee);
    List<Employee> getEmployeeByRoleID(Long ID);
    double computeYearlySalary(Long ID);
}
