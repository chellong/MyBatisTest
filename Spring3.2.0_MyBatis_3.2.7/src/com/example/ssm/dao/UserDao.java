package com.example.ssm.dao;

import com.example.ssm.po.User;

public interface UserDao {

	public User findUserById(int id) throws Exception;
	
	public void insertUser(User user) throws Exception;
	
	public void deleteUserById(int id) throws Exception;
	
	public void updateUser(User user) throws Exception;
}
