package com.sysbytes.user1.service;

import java.util.List;

import com.sysbytes.user1.model.User;

public interface UserService {
	
	public List<User> getAllUsers();
	public User getSingleUser(Long id);
	void createUser(User user);
	void deleteUser(Long id);
	void updateUser(User user);

}
