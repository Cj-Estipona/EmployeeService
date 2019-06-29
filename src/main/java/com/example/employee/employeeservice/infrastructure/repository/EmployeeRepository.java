package com.example.employee.employeeservice.infrastructure.repository;

import com.example.employee.employeeservice.core.Employee;
import com.example.employee.employeeservice.infrastructure.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
    List<EmployeeEntity> findAllByEmployeeRoleEntity_RoleID(Long ID);
    EmployeeEntity findEmployeeEntityByEmployeeID(Long ID);
}
