package com.sush.first.dao;

import com.sush.first.model.User;

public interface UserDAO {
	
	//public User updatePassword(User user, String newPassword);
	//public User updateEmail(User user,String newEmail);
	public void deleteUser(User user);
	public void insertUser(User user);
	public User getUserDetails(String username);
	public void updateUser(User user);
}
