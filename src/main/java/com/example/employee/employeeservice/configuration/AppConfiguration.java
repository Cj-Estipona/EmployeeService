package com.example.employee.employeeservice.configuration;


import com.example.employee.employeeservice.core.dao.EmployeeDAO;
import com.example.employee.employeeservice.core.service.EmployeeService;
import com.example.employee.employeeservice.core.service.impl.EmployeeServiceImpl;
import com.example.employee.employeeservice.infrastructure.dao.EmployeeDAOImpl;
import com.example.employee.employeeservice.infrastructure.repository.EmployeeRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {
//    @Bean
//    EmployeeDAO employeeDao(EmployeeRepository employeeRepository){
//        return new EmployeeDAOImpl(employeeRepository);
//    }

//    @Bean
//    EmployeeService employeeService(EmployeeDAO employeeDAO){
//        return new EmployeeServiceImpl(employeeDAO);
//    }
}
