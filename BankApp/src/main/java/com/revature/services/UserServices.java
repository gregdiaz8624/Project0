package com.revature.services;

import java.util.Scanner;

import com.revature.models.User;

public interface UserServices {

	public User login(Scanner s);
	public void register(Scanner s); 

}