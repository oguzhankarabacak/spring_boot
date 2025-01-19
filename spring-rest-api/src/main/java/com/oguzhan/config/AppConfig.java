package com.oguzhan.config;

import com.oguzhan.model.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class AppConfig {
    @Bean
    public List<Employee> employeeList(){
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("1","Oguz","Kara"));
        employeeList.add(new Employee("5","Oguz","Kara"));
        employeeList.add(new Employee("2","Mehmet","Cetin"));
        employeeList.add(new Employee("3","Hasan","Keten"));
        employeeList.add(new Employee("4","Ahmet","Cıkmaz"));

        return employeeList;
    }
}
