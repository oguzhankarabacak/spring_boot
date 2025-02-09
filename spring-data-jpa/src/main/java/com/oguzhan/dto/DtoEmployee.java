package com.oguzhan.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.oguzhan.entities.Department;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class DtoEmployee {
    private Long id;
    private String name;
    private DtoDepartment department;
}
