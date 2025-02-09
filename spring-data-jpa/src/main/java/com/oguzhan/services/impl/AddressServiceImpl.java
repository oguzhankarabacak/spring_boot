package com.oguzhan.services.impl;

import com.oguzhan.dto.DtoAddress;
import com.oguzhan.dto.DtoCustomer;
import com.oguzhan.entities.Address;
import com.oguzhan.entities.Customer;
import com.oguzhan.repository.IAddressRepository;
import com.oguzhan.services.IAddressService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressServiceImpl implements IAddressService {
    @Autowired
    IAddressRepository addressRepository;
    @Override
    public DtoAddress getAddressbyId(Long id) {
        Optional<Address> optionalAddress = addressRepository.findById(id);
        if (optionalAddress.isPresent()) {
            Address address = optionalAddress.get();
            Customer customer = address.getCustomer();

            DtoAddress dtoAddress = new DtoAddress();
            DtoCustomer dtoCustomer = new DtoCustomer();

            BeanUtils.copyProperties(address, dtoAddress);
            BeanUtils.copyProperties(customer, dtoCustomer);

            dtoAddress.setCustomer(dtoCustomer);

            return dtoAddress;

        }
        return null;
    }
}
