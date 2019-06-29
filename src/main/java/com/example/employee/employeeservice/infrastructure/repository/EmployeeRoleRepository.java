package com.example.employee.employeeservice.infrastructure.repository;

import com.example.employee.employeeservice.infrastructure.entity.EmployeeRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRoleRepository extends JpaRepository<EmployeeRoleEntity, Long> {
}
