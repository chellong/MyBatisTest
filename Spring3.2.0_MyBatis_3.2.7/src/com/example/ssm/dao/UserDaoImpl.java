package com.example.ssm.dao;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.example.ssm.po.User;


public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao{
	
	@Override
	public User findUserById(int id) throws Exception {
		SqlSession sqlSession = this.getSqlSession();
		User user = sqlSession.selectOne("test.findUserById", id);
		return user;
	}

	@Override
	public void insertUser(User user) throws Exception {
		SqlSession sqlSession = this.getSqlSession();
		sqlSession.insert("test.insertUser", user);
		sqlSession.commit();
	}

	@Override
	public void deleteUserById(int id) throws Exception {
		SqlSession sqlSession = this.getSqlSession();
		sqlSession.delete("test.deleteUserById", id);
		sqlSession.commit();		
	}

	@Override
	public void updateUser(User user) throws Exception {
		SqlSession sqlSession = this.getSqlSession();
		sqlSession.update("test.updateUser", user);
		sqlSession.commit();
	}

}
