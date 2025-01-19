package com.oguzhan.main;

import java.util.ArrayList;
import java.util.List;

import com.oguzhan.model.User;
import com.oguzhan.services.UserService;

public class MainClass {
	
	public static void main(String[] args) {
		UserService userService1 = new UserService();
		
		List<User> userList = new ArrayList<>();
		
		userList.add(new User("Enes"));
		
	}
}
