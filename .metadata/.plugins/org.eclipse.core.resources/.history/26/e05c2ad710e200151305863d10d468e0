package com.example.mapperdao;

import java.util.List;

import com.example.domain.User;
import com.example.domain.UserCustom;
import com.example.domain.UserQueryVo;

public interface UserMapper {
	
	public List<UserCustom> findUserList(UserQueryVo userQueryVo) throws Exception;
	
	public int findUserCount(UserQueryVo userQueryVo) throws Exception;
	
	public User findUserByIdResultMap(int id) throws Exception;
	
	public User findUserById(int id) throws Exception;
	
	public List<User> findUserByName(String name) throws Exception;
	
	public void insertUser(User user) throws Exception;
	
	public void deleteUserById(int id) throws Exception;
	
	public void updateUser(User user) throws Exception;
}
