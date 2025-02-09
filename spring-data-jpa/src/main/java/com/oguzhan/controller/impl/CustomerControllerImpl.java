package com.oguzhan.controller.impl;

import com.oguzhan.controller.ICustomerController;
import com.oguzhan.dto.DtoCustomer;
import com.oguzhan.services.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/api/customer")
public class CustomerControllerImpl implements ICustomerController {

    @Autowired
    private ICustomerService customerService;

    @GetMapping(path = "/list/{id}")
    @Override
    public DtoCustomer getCustomerbyId(@PathVariable(name = "id") Long id) {
        return customerService.getCustomerbyId(id);
    }
}
