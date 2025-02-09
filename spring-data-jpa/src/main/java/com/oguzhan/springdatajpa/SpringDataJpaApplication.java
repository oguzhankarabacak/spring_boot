package com.oguzhan.springdatajpa;

import com.oguzhan.configuration.GlobalProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = {"com.oguzhan.entities"})
@SpringBootApplication
@ComponentScan(basePackages = {"com.oguzhan"})
@EnableJpaRepositories(basePackages = {"com.oguzhan"})
//@PropertySource(value = "classpath:application.properties")
@EnableConfigurationProperties(value = GlobalProperties.class) //ConfigurationProperties class
public class SpringDataJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaApplication.class, args);
    }

}
