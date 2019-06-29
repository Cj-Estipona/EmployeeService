package com.example.employee.employeeservice.presentation;


import com.example.employee.employeeservice.core.Employee;
import com.example.employee.employeeservice.core.service.EmployeeService;
import com.example.employee.employeeservice.presentation.dto.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app")
public class EmployeeController {

    private EmployeeService employeeService;
    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping(value = "/employee")
    public List<Employee> getEmployee(){
        return employeeService.getAllEmployeesWithRole();
    }

    @PostMapping(value = "/newEmployee")
    public Boolean createEmployee(@RequestBody EmployeeDTO employeeDTO){
        return null != employeeService.createNewEmployee(employeeDTO);
    }

    @PostMapping(value = "/employeeByRole")
    public List<Employee> getEmployeeByRoleID(@RequestHeader Long roleID){
        return employeeService.getEmployeeByRoleID(roleID);
    }

    @PostMapping(value = "/employeeYearlySalary")
    public String computeYearlySalary(@RequestHeader Long employeeID){
        return "Php " + employeeService.computeYearlySalary(employeeID);
    }

}
