package com.oguzhan.exceptionmanagement;

import jakarta.persistence.Entity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

@SpringBootApplication
@EntityScan(basePackages = {"com.oguzhan"})
@EnableJpaRepositories(basePackages = {"com.oguzhan"})
@ComponentScan(basePackages = {"com.oguzhan"})
@EnableScheduling
public class ExceptionManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExceptionManagementApplication.class, args);
    }

}
