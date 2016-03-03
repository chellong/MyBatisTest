package com.example.testdomain;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.example.domain.User;

/**
 * 测试
 * 
 * @author 北飞的候鸟
 *
 */
public class TestUser {

	/**
	 * mybatis会话
	 */
	private static SqlSession sqlSession;

	@BeforeClass
	public static void afterClass() throws IOException {
		// 配置文件
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 创建会话工厂传入配置文件信息
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(inputStream);
		// 得到会话
		sqlSession = ssf.openSession();
	}

	@Test
	public void testFindUserById() {

		User user = sqlSession.selectOne("test.findUserById", 1);
		System.out.println(user);

	}

	/**
	 * 根据用户名查找
	 */
	@Test
	public void testFindUserByName() {

		List<User> list = sqlSession.selectList("test.findUserByName", "铭");
		for (User u : list) {
			System.out.println(u);
		}

	}

	@Test
	public void testInsertUser() {

		User user = new User();
		user.setUsername("銘");
		user.setSex("女");
		user.setBirthDay(new Date());
		user.setAddress("白銀");

		sqlSession.insert("test.insertUser", user);

		System.out.println(user);
		sqlSession.commit();
	}

	@Test
	public void testDeleteUser() {

		sqlSession.delete("test.deleteUserById", 8);
		sqlSession.commit();
	}

	@Test
	public void testUpdateUser() {

		User user = new User();
		user.setId(1);
		user.setUsername("龍");
		user.setSex("男");
		user.setBirthDay(new Date());
		user.setAddress("白銀");

		sqlSession.update("test.updateUser", user);
		sqlSession.commit();
	}

	@AfterClass
	public static void acterClass() {

		if (sqlSession != null) {
			sqlSession.close();
		}
	}
}
