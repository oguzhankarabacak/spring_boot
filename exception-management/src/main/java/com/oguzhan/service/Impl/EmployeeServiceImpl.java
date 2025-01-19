package com.oguzhan.service.Impl;

import com.oguzhan.dto.DtoDepartment;
import com.oguzhan.dto.DtoEmployee;
import com.oguzhan.exception.BaseException;
import com.oguzhan.exception.ErrorMessage;
import com.oguzhan.exception.MessageType;
import com.oguzhan.model.Department;
import com.oguzhan.model.Employee;
import com.oguzhan.repository.IEmployeeRepository;
import com.oguzhan.service.IEmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    IEmployeeRepository employeeRepository;

    @Override
    public DtoEmployee getEmployeeById(Long id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isEmpty()) {
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, id.toString()));
        }
        Employee employee = optionalEmployee.get();
        Department department = employee.getDepartment();

        DtoEmployee dtoEmployee = new DtoEmployee();
        DtoDepartment dtoDepartment = new DtoDepartment();

        BeanUtils.copyProperties(employee, dtoEmployee);
        BeanUtils.copyProperties(department, dtoDepartment);

        dtoEmployee.setDepartment(dtoDepartment);

        return dtoEmployee;
    }
}
