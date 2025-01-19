package com.oguzhan.controller.Impl;

import com.oguzhan.controller.IRestEmployeeController;
import com.oguzhan.dto.DtoEmployee;
import com.oguzhan.exception.BaseException;
import com.oguzhan.model.RootEntity;
import com.oguzhan.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/api/employee")
public class RestEmployeeController extends RestBaseController implements IRestEmployeeController {
    @Autowired
    private IEmployeeService employeeService;

    @GetMapping("/list/{id}")
    @Override
    public RootEntity<DtoEmployee> getEmployeeById(@PathVariable(value = "id") Long id) {
        try {
            return ok(employeeService.getEmployeeById(id));
        }
        catch(BaseException e){
            return error(e.getMessage());
        }

    }
}
