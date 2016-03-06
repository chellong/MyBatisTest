package com.example.ssm.dao;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.ssm.po.User;

public class UserDaoImplTest {

	private ApplicationContext applicationContext;
	@Before
	public void testBefore(){
		applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
	}
	
	@Test
	public void testFindUserById() {
		UserDao userDao = (UserDao) applicationContext.getBean("userDao");
		try {
			User user = userDao.findUserById(1);
			System.out.println(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
