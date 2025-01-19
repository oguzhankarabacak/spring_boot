package com.oguzhan.springrestapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.oguzhan"})  //com.oguzhan içindeki her şeyi tara, component anatasyonunu extend etmiş
// (@Repository, @Controller, @Service) sınıfları bul, Spring Containerda beamlerinin oluşmasını sağla.
@SpringBootApplication
public class SpringRestApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringRestApiApplication.class, args);
    }

}
