package com.oguzhan.controller;

import com.oguzhan.dto.DtoEmployee;

public interface IEmployeeController {
    public DtoEmployee getEmployeeById(Long id);
}
