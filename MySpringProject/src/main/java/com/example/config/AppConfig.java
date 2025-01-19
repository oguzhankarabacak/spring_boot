package com.example.config;

import com.example.model.User;
import com.example.services.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class AppConfig {
    @Bean
    public UserService userService() {
        UserService userService = new UserService();

        List<User> userList = new ArrayList<>();

        userList.add(new User("Oguzhan"));
        userList.add(new User("Ali"));

        userService.setUserList(userList);

        return userService;
    }
}
