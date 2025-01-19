package com.oguzhan.exceptionmanagement;

import com.oguzhan.dto.DtoEmployee;
import com.oguzhan.service.IEmployeeService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = {ExceptionManagementApplication.class})
class ExceptionManagementApplicationTests {

    @Autowired
    private IEmployeeService employeeService;

    @BeforeEach
    public void beforeEach() {
        System.out.println("beforeEach works...");    //works before test
    }

    @AfterEach
    public void afterEach() {
        System.out.println("afterEach works...");   ////works after test
    }

    @Test
    public void testGetEmployeeById() {
        DtoEmployee dtoEmployee = employeeService.getEmployeeById(1L);
        assertNotNull(dtoEmployee);
        //assertEquals(4,6);
        if (dtoEmployee != null) {
            System.out.println("Isim : " + dtoEmployee.getName());
        }
    }
}
