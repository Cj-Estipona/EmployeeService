package com.example.employee.employeeservice.core.dao;

import com.example.employee.employeeservice.core.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAllEmployee();
    Employee saveNewEmployee(Employee employee);
    List<Employee> findAllEmployeeByRoleID(Long ID);
    double computeYearlySalary(Long ID);
}
