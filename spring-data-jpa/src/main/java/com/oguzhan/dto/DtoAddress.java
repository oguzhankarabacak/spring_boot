package com.oguzhan.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.oguzhan.entities.Customer;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class DtoAddress {
    private Long id;

    private String description;

    private DtoCustomer customer;
}
