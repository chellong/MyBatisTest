package com.example.testcache;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

import com.example.domain.User;
import com.example.mapper.UserMapper;

public class CacheTest {

	private static SqlSessionFactory sqlSessionFactory;

	@BeforeClass
	public static void afterClass() throws IOException {
		// 配置文件
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 创建会话工厂传入配置文件信息
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void testCache_1() {

		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		/**
		 * 第一次查询id=1；
		 */
		try {
			userMapper.findUserById(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		/**
		 * 如果commit会清空缓存
		 */
		User user = new User();
			user.setId(1);
			user.setUsername("user_1");
			user.setSex("女");
			user.setBirthDay(new Date());
			user.setAddress("白銀");
		
			sqlSession.commit();
		try {
			userMapper.updateUser(user);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		/**
		 * 第二次id=1；
		 */
		try {
			userMapper.findUserById(1);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@Test
	public void testCache_2() {

		SqlSession sqlSession_1 = sqlSessionFactory.openSession();
		SqlSession sqlSession_2 = sqlSessionFactory.openSession();
		SqlSession sqlSession_3 = sqlSessionFactory.openSession();
		
		UserMapper userMapper_1 = sqlSession_1.getMapper(UserMapper.class);
		/**
		 * 第一次查询id=1；
		 */
		try {
			userMapper_1.findUserById(1);
			sqlSession_1.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		/**
		 * 第二次id=1；
		 */
		UserMapper userMapper_2 = sqlSession_2.getMapper(UserMapper.class);
		try {
			userMapper_2.findUserById(1);
			sqlSession_2.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		UserMapper userMapper_3 = sqlSession_3.getMapper(UserMapper.class);
		try {
			User user = new User();
			user.setId(1);
			user.setUsername("user_1");
			user.setSex("女");
			user.setBirthDay(new Date());
			user.setAddress("白銀");
		
			userMapper_3.updateUser(user);
			sqlSession_3.commit();
			sqlSession_3.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
