package com.revature.repositories;

import com.revature.models.Employee;

public interface EmployeeRepo {
	
	Employee getEmployee(String user, String pass);

}
