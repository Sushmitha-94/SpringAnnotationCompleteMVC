package com.sush.first.service;

import com.sush.first.model.User;

public interface UserService {
	
	public User userLogin(String username, String password);
	public void updatePassword(User user, String newPassword);
	public void updateEmail(User user,String newEmail);
	public void deleteUser(User user);
	public void setUpUser(User user);
}
