package com.revature.services;

import java.util.List;

import com.revature.models.User;

public interface UserServices {
	
	User addUser(User u);

	User getUser(Integer id);

	List<User> getAllUser();
	
	boolean updateUser(User u);
	
	boolean deleteUser(User u);
	

}

