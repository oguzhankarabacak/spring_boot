package com.oguzhan.service;

import com.oguzhan.dto.DtoEmployee;

public interface IEmployeeService {

    public DtoEmployee getEmployeeById(Long id);
}
