package com.example.employee.employeeservice.presentation

import com.example.employee.employeeservice.core.Employee
import com.example.employee.employeeservice.core.EmployeeRole
import com.example.employee.employeeservice.core.service.EmployeeService
import groovy.json.JsonSlurper
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import spock.lang.Shared
import spock.lang.Specification


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(controllers =[EmployeeController])
@ActiveProfiles("test")
class EmployeeControllerSpec extends  Specification{

    private MockMvc mockMvc

    private EmployeeService employeeService

    def setup(){
        employeeService = Stub(EmployeeService.class)
        EmployeeController employeeController = new EmployeeController(employeeService)
        mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build()
    }

    @Shared
    EmployeeRole employeeRole = new EmployeeRole(1, "Full-stack Engineer")

    def "should return employee records"(){
        given:
        List<Employee> employee = [
                new Employee(1, "Christian", 25000.00, employeeRole)
        ]

        and:
        employeeService.getAllEmployeesWithRole() >> employee

        when:
        def result = mockMvc.perform(get("/app/employee"))


        then:
        result.andExpect(status().isOk())
        def responseContent = new JsonSlurper().parseText(result.andReturn().response.contentAsString)
        responseContent.size() == 1

        def resultFirstEmployee = responseContent[0]
        def sourceFirstEmployee = employee[0]

        resultFirstEmployee.employeeID == sourceFirstEmployee.employeeID
        resultFirstEmployee.employeeRole.roleID == sourceFirstEmployee.employeeRole.roleID

    }
}


