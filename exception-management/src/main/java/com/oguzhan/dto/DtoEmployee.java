package com.oguzhan.dto;

import com.oguzhan.model.Department;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoEmployee {
    private long id;

    private String name;

    private DtoDepartment department;
}
