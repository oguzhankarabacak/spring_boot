package com.oguzhan.controller;

import com.oguzhan.dto.DtoEmployee;
import com.oguzhan.model.RootEntity;

public interface IRestEmployeeController {
    public RootEntity<DtoEmployee> getEmployeeById(Long id);
}
