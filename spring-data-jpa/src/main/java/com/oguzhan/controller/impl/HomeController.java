package com.oguzhan.controller.impl;

import com.oguzhan.controller.IHomeController;
import com.oguzhan.dto.DtoHome;
import com.oguzhan.dto.DtoStudent;
import com.oguzhan.services.IHomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/api/home")
public class HomeController implements IHomeController {

    @Autowired
    IHomeService homeService;

    @GetMapping("/list/{id}")
    @Override
    public DtoHome getHomeById(@PathVariable(name = "id")  Long id) {
        return homeService.getHomeById(id);
    }


}
