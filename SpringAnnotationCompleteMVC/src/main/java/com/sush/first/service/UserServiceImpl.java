package com.sush.first.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sush.first.dao.UserDAO;
import com.sush.first.model.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO userDAO;
	
	public User userLogin(String username, String password) {
		User user = userDAO.getUserDetails(username);
		if(user.getPassword().equals(password))
			return user;
		else
			return null;
	}

	public void updatePassword(User user, String newPassword) {
		user.setPassword(newPassword);
		userDAO.updateUser(user);
	}

	public void updateEmail(User user, String newEmail) {
		user.setEmail(newEmail);
		userDAO.updateUser(user);
	}

	public void deleteUser(User user) {
		userDAO.deleteUser(user);
	}

	public void setUpUser(User user) {
		userDAO.insertUser(user);
	}

}
