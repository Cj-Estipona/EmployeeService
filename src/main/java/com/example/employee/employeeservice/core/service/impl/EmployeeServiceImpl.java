package com.example.employee.employeeservice.core.service.impl;

import com.example.employee.employeeservice.core.Employee;
import com.example.employee.employeeservice.core.dao.EmployeeDAO;
import com.example.employee.employeeservice.core.service.EmployeeService;
import com.example.employee.employeeservice.presentation.dto.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    EmployeeDAO employeeDAO;

    public EmployeeServiceImpl(EmployeeDAO employeeDAO){
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> getAllEmployeesWithRole() {
        return employeeDAO.findAllEmployee();
    }

    public Employee createNewEmployee(EmployeeDTO employeeDTO){
        Employee employee = mapNewEmployeeToEmployee(employeeDTO);
        return employeeDAO.saveNewEmployee(employee);
    }

    private Employee mapNewEmployeeToEmployee(EmployeeDTO employeeDTO){
        Employee employee = Employee.builder()
                .employeeName(employeeDTO.getEmployeeName())
                .employeeSalary(employeeDTO.getEmployeeSalary())
                .employeeRole(employeeDTO.getEmployeeRole())
                .build();
        return employee;
    }

    @Override
    public List<Employee> getEmployeeByRoleID(Long ID){
        return employeeDAO.findAllEmployeeByRoleID(ID);
    }

    @Override
    public double computeYearlySalary(Long ID){
        return employeeDAO.computeYearlySalary(ID);
    }
}
