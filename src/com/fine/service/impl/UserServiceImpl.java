//@author pavithra

package com.fine.service.impl;

import java.util.List;


import com.fine.bean.Employee;
import com.fine.bean.User;
import com.fine.dao.UserDAO;
import com.fine.dao.impl.UserDAOImpl;
import com.fine.exception.InvalidOIDException;
import com.fine.service.UserService;

public class UserServiceImpl implements UserService {
	UserDAO userDao=null;
	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		userDao = new UserDAOImpl();
		boolean value=userDao.addUser(user);
		if(value){
			System.out.println(user.getPassword());
			if(user.getPassword().equals("admin")){
				
				return true;
		}
		}
			
	return false;
	
	}

	@Override
	public boolean deleteUser(int oID) throws InvalidOIDException {
		userDao = new UserDAOImpl();
		boolean value = userDao.deleteUser(oID);
		return value;
	}

	@Override
	public List<Employee> viewUsers() {
		userDao = new UserDAOImpl();
		return userDao.viewUsers();
	}

	@Override
	public boolean logInUser(User user) {
		userDao = new UserDAOImpl();
		boolean value = userDao.logInUser(user);
		return value;
	}

	@Override
	public Employee getEmployeeByID(int oID) {
		userDao = new UserDAOImpl();
		Employee employee = userDao.getEmployeeByID(oID);
		return employee;
	}

	@Override
	public boolean changePassword(int oID, String newPassword)throws InvalidOIDException{
		// TODO Auto-generated method stub
		boolean flag = false;
		userDao = new UserDAOImpl();
		flag = userDao.changePassword(oID, newPassword);
		return flag;
	}

	@Override
	public User getUserByID(int oID) {
		userDao = new UserDAOImpl();
		User user = userDao.getUserByID(oID);
		return user;
	}

	@Override
	public boolean uploadImage(String imageName, int oID) {
		userDao = new UserDAOImpl();
		boolean added = userDao.uploadImage(imageName, oID);
		return added;
	}

}
