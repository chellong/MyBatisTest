package com.example.mapper;

import java.util.List;

import com.example.domain.Orders;
import com.example.domain.User;
import com.example.domain.po.OrdersCustom;

/**
 * 
 * @author ±±·ÉµÄºòÄñ
 */

public interface OrdersMapperCustom {

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<OrdersCustom> findOedersUser() throws Exception;
	
	/**
	 * findOedersUserResultMap
	 * @return
	 * @throws Exception
	 */
	public List<Orders> findOedersUserResultMap() throws Exception;
	
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<Orders> findOedersAndOrderDetialResultMap() throws Exception;
	
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<User> findUserAndItemsResultMap() throws Exception;
}
