package com.oguzhan.services.impl;

import com.oguzhan.dto.DtoDepartment;
import com.oguzhan.dto.DtoEmployee;
import com.oguzhan.entities.Department;
import com.oguzhan.entities.Employee;
import com.oguzhan.repository.IEmployeeRepository;
import com.oguzhan.services.IEmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImp implements IEmployeeService {
    @Autowired
    IEmployeeRepository employeeRepository;


    @Override
    public DtoEmployee getEmployeeById(Long id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            Department department = employee.getDepartment();

            DtoEmployee dtoEmployee = new DtoEmployee();
            DtoDepartment dtoDepartment = new DtoDepartment();

            BeanUtils.copyProperties(employee, dtoEmployee);
            BeanUtils.copyProperties(department, dtoDepartment);

            dtoEmployee.setDepartment(dtoDepartment);

            return dtoEmployee;
        }
        return null;
    }
}
