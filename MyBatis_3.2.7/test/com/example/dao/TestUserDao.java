package com.example.dao;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

import com.example.dao.UserDao;
import com.example.daoimpl.UserDaoImpl;
import com.example.domain.User;

public class TestUserDao {

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
	public void testUserDao() {
		UserDao dao = new UserDaoImpl(sqlSessionFactory);
		try {
			User user = dao.findUserById(1);
			System.out.println(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
