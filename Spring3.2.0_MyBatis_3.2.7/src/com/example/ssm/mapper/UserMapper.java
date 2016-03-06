package com.example.ssm.mapper;


import com.example.ssm.po.User;


public interface UserMapper {
	
	public User findUserById(int id) throws Exception;
	
}
