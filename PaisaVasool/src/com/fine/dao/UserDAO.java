package com.fine.dao;

import java.util.List;


import com.fine.bean.Employee;
import com.fine.bean.User;
import com.fine.exception.InvalidOIDException;

public interface UserDAO {

boolean addUser(User user);
	
	boolean deleteUser(int oID) throws InvalidOIDException;
	
	List<Employee> viewUsers();
	boolean logInUser(User user);
	
	Employee getEmployeeByID(int oID);
	
	User getUserByID(int oID);
	
	boolean changePassword(int oID, String newPassword)throws InvalidOIDException;
}
