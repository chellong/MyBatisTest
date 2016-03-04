package com.example.domain.po;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

import com.example.domain.OrderDetial;
import com.example.domain.Orders;
import com.example.mapper.OrdersMapperCustom;

public class OrdersCustomTest {

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
	public void testFindOedersUser() {
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrdersMapperCustom OrdersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);
		try {
			List<OrdersCustom> list = OrdersMapperCustom.findOedersUser();
			for(OrdersCustom oc : list ){
				System.out.println(oc.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testFindOedersUserResultMap() {
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrdersMapperCustom OrdersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);
		try {
			List<Orders> list = OrdersMapperCustom.findOedersUserResultMap();
			for(Orders odr : list ){
				System.out.println(odr.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testFindOedersAndOrderDetialResultMap() {
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrdersMapperCustom OrdersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);
		try {
			List<Orders> list = OrdersMapperCustom.findOedersAndOrderDetialResultMap();
			for(Orders odr : list ){
				OrderDetial od = odr.getOrderDetails().get(0);
				System.out.println(od);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
