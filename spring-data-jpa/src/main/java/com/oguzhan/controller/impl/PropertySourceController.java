package com.oguzhan.controller.impl;

import com.oguzhan.configuration.DataSource;
import com.oguzhan.configuration.GlobalProperties;
import com.oguzhan.configuration.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("rest/api/property")
public class PropertySourceController {

    @Autowired
    private GlobalProperties globalProperties;

    @GetMapping("/datasource")
    public DataSource getDataSource() {
        DataSource dataSource = new DataSource();
        dataSource.setUrl(globalProperties.getUrl());
        dataSource.setUsername(globalProperties.getUsername());
        dataSource.setPassword(globalProperties.getPassword());
        return dataSource;
    }

    @GetMapping("/serverlist")
    public List<Server> getServerList() {
        return globalProperties.getServers();
    }
}
