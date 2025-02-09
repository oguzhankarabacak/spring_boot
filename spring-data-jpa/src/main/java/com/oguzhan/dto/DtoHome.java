package com.oguzhan.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoHome {

    private Long id;
    private BigDecimal price;
    private List<DtoRoom> roomList;
}
