package com.example.employee.employeeservice.configuration

import com.example.employee.employeeservice.core.service.EmployeeService
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Profile
import spock.mock.DetachedMockFactory

@TestConfiguration
@Profile("test")
class ServiceTestConfiguration {
    DetachedMockFactory detachedMockFactory = new DetachedMockFactory()

    @Bean
    EmployeeService employeeService() {
        detachedMockFactory.Stub(EmployeeService)
    }
}
