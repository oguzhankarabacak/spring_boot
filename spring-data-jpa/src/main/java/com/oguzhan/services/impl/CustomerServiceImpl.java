package com.oguzhan.services.impl;

import com.oguzhan.dto.DtoAddress;
import com.oguzhan.dto.DtoCustomer;
import com.oguzhan.entities.Address;
import com.oguzhan.entities.Customer;
import com.oguzhan.repository.ICustomerRepository;
import com.oguzhan.services.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public DtoCustomer getCustomerbyId(Long id) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if (optionalCustomer.isPresent()) {
            DtoCustomer dtoCustomer = new DtoCustomer();
            DtoAddress dtoAddress = new DtoAddress();
            Customer customer = optionalCustomer.get();
            Address address = customer.getAddress();

            BeanUtils.copyProperties(customer, dtoCustomer);
            BeanUtils.copyProperties(address, dtoAddress);

            dtoCustomer.setAddress(dtoAddress);
            return dtoCustomer;
        }
        return null;
    }
}
