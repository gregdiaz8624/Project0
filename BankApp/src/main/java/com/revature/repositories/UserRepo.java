package com.revature.repositories;

import java.util.List;


import com.revature.models.User;

public interface UserRepo {

		void addUser(User u);
		User getUserById(Integer id);
		User getUser(String un, String pw);
		User getUserNoAcc(String un, String pw);
		List<User> getUsers();
		
		
		
}