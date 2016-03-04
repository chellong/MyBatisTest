package com.example.domain;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.example.domain.User;

/**
 * ����
 * 
 * @author ���ɵĺ���
 *
 */
public class TestUser {

	/**
	 * mybatis�Ự
	 */
	private static SqlSession sqlSession;

	@Before
	public static void afterClass() throws IOException {
		// �����ļ�
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// �����Ự�������������ļ���Ϣ
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(inputStream);
		// �õ��Ự
		sqlSession = ssf.openSession();
	}

	@Test
	public void testFindUserById() {

		User user = sqlSession.selectOne("test.findUserById", 1);
		System.out.println(user);

	}

	/**
	 * �����û�������
	 */
	@Test
	public void testFindUserByName() {

		List<User> list = sqlSession.selectList("test.findUserByName", "��");
		for (User u : list) {
			System.out.println(u);
		}

	}

	@Test
	public void testInsertUser() {

		User user = new User();
		user.setUsername("�");
		user.setSex("Ů");
		user.setBirthDay(new Date());
		user.setAddress("���y");

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
		user.setUsername("��");
		user.setSex("��");
		user.setBirthDay(new Date());
		user.setAddress("���y");

		sqlSession.update("test.updateUser", user);
		sqlSession.commit();
	}

	@After
	public static void acterClass() {

		if (sqlSession != null) {
			sqlSession.close();
		}
	}
}