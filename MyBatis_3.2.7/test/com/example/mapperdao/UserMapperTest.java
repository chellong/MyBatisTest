package com.example.mapperdao;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

import com.example.domain.User;
import com.example.domain.UserCustom;
import com.example.domain.UserQueryVo;
import com.example.mapper.UserMapper;

public class UserMapperTest {

	private static SqlSessionFactory sqlSessionFactory;
	
	@BeforeClass
	public static void afterMethod() throws IOException {
		// 配置文件
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 创建会话工厂传入配置文件信息
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	@Test
	public void testfindUserList() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		UserQueryVo userQueryVo = new UserQueryVo();
		UserCustom userCustom = new UserCustom();
		userCustom.setUsername("銘");
		userCustom.setSex("女");
		userQueryVo.setUserCustom(userCustom);
		
		List<Integer> listInt = new ArrayList<>();
		listInt.add(1);
		listInt.add(2);
		listInt.add(3);
		listInt.add(4);
		listInt.add(5);
		userQueryVo.setIds(listInt);
		
		try {
			List<UserCustom> list= userMapper.findUserList(userQueryVo);
//			List<UserCustom> list= userMapper.findUserList(null);
			/**
			 * hi
			 */
			System.out.println("总数" + userMapper.findUserCount(userQueryVo));
			for(UserCustom uc : list){
				System.out.println(uc);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testFindUserById() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		try {
			User user = userMapper.findUserById(1);
			System.out.println(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testFindUserByIdResultMap() {
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
	
		try {
			User user = userMapper.findUserByIdResultMap(1);
			System.out.println(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testFindUserByName() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		try {
			List<User> list= userMapper.findUserByName("銘");
			for(User user : list){
				System.out.println(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Test
	public void testInsertUser() {
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		try {
			
			User user = new User();
			user.setUsername("琪");
			user.setSex("女");
			user.setBirthDay(new Date());
			user.setAddress("白银");
			userMapper.insertUser(user );
			
			System.out.println(user.getId());
			
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testDeleteUserById() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		try {
			userMapper.deleteUserById(13);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Test
	public void testUpdateUser() {
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		User user = new User();
		user.setId(2);
		user.setUsername("琪");
		user.setSex("女");
		user.setBirthDay(new Date());
		user.setAddress("白银");
		try {
			userMapper.updateUser(user);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
