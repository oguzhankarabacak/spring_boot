package com.oguzhan.services;

import com.oguzhan.dto.DtoEmployee;

public interface IEmployeeService {
    public DtoEmployee getEmployeeById(Long id);
}
