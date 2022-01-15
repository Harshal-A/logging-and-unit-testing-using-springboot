package com.web.orders.bo;

import com.web.orders.entity.Order;
import com.web.orders.exception.BOException;

public interface OrderBO {

	boolean placeOrder(Order order) throws BOException;
	
	boolean cancelOrder(int id) throws BOException;
	
	boolean deleteOrder(int id) throws BOException;
	
}
