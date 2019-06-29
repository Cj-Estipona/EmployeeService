package com.example.employee.employeeservice.infrastructure.dao;

import com.example.employee.employeeservice.core.Employee;
import com.example.employee.employeeservice.core.EmployeeRole;
import com.example.employee.employeeservice.core.dao.EmployeeDAO;
import com.example.employee.employeeservice.infrastructure.entity.EmployeeEntity;
import com.example.employee.employeeservice.infrastructure.entity.EmployeeRoleEntity;
import com.example.employee.employeeservice.infrastructure.repository.EmployeeRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeDAOImpl implements EmployeeDAO {
    private EmployeeRepository employeeRepository;

    public EmployeeDAOImpl(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAllEmployee(){
        List<EmployeeEntity> employeeEntityGroup = employeeRepository.findAll();
        List<Employee> employees = mapEmployeeEntities(employeeEntityGroup);
        return employees;
    }

    private List<Employee> mapEmployeeEntities(List<EmployeeEntity> employeeEntityGroup){
        List<Employee> employees = new ArrayList<>();
        employeeEntityGroup.forEach(employeeEntity -> {
            EmployeeRole employeeRole = mapEmployeeRoleEntityToEmployeeRole(employeeEntity.getEmployeeRoleEntity());
            Employee employee = Employee.builder()
                    .employeeID(employeeEntity.getEmployeeID())
                    .employeeName(employeeEntity.getEmployeeName())
                    .employeeSalary(employeeEntity.getEmployeeSalary())
                    .employeeRole(employeeRole)
                    .build();
            employees.add(employee);
        });
        return employees;
    }

    public Employee saveNewEmployee(Employee employee){
        EmployeeRoleEntity employeeRoleEntity = mapEmployeeRoleToEmployeeRoleEntity(employee);
        EmployeeEntity employeeEntityToSave = mapEmployeeEntityToBeSaved(employee, employeeRoleEntity);
        employeeRepository.save(employeeEntityToSave);
        return employee;
    }

    private EmployeeRoleEntity mapEmployeeRoleToEmployeeRoleEntity(Employee employee){
        return EmployeeRoleEntity.builder()
                .roleID(employee.getEmployeeRole().getRoleID())
                //.roleName(employee.getEmployeeRole().getRoleName())
                .build();
    }

    private EmployeeRole mapEmployeeRoleEntityToEmployeeRole(EmployeeRoleEntity employeeRoleEntity){
        return EmployeeRole.builder()
                .roleID(employeeRoleEntity.getRoleID())
                .roleName(employeeRoleEntity.getRoleName())
                .build();
    }

    private EmployeeEntity mapEmployeeEntityToBeSaved(Employee employee, EmployeeRoleEntity employeeRoleEntity){
        return EmployeeEntity.builder()
                .employeeID(employee.getEmployeeID())
                .employeeName(employee.getEmployeeName())
                .employeeSalary(employee.getEmployeeSalary())
                .employeeRoleEntity(employeeRoleEntity)
                .build();
    }
    public List<Employee> findAllEmployeeByRoleID(Long ID){
        List<EmployeeEntity> employeeEntityGroup = employeeRepository.findAllByEmployeeRoleEntity_RoleID(ID);
        List<Employee> employee = mapEmployeeEntities(employeeEntityGroup);
        return employee;
    }

    public double computeYearlySalary(Long ID){
        EmployeeEntity employeeEntityGroup = employeeRepository.findEmployeeEntityByEmployeeID(ID);
        double employeeYearlySalary = employeeEntityGroup.getEmployeeSalary() * 12;
        return employeeYearlySalary;
    }
}
