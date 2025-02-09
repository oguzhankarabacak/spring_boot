package com.oguzhan.controller.impl;

import com.oguzhan.controller.IEmployeeController;
import com.oguzhan.dto.DtoEmployee;
import com.oguzhan.services.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/api/employee")
public class EmployeeControllerImpl implements IEmployeeController {
    @Autowired
    IEmployeeService employeeService;

    @GetMapping("/list/{id}")
    @Override
    public DtoEmployee getEmployeeById(@PathVariable(name = "id") Long id) {
        return employeeService.getEmployeeById(id);
    }
}
