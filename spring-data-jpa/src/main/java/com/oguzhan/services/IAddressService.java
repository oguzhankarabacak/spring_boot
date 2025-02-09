package com.oguzhan.services;

import com.oguzhan.dto.DtoAddress;
import com.oguzhan.dto.DtoCustomer;

public interface IAddressService {
    public DtoAddress getAddressbyId(Long id);
}
