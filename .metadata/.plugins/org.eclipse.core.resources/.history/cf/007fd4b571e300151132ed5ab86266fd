package com.example.ssm.mapper;


import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.ssm.po.User;

public class UserMapperTest {
	
	private static ApplicationContext applicationContext;
	
	@Before
	public  void testBefore(){
		applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
	}

	@Test
	public void testFindUserById() {
		
		UserMapper userMapper = (UserMapper) applicationContext.getBean("userMapper");
		try {
			User user = userMapper.findUserById(1);
			System.out.println(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
