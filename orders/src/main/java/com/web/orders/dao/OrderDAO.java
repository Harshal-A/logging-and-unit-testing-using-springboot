package com.web.orders.dao;

import java.sql.SQLException;

import com.web.orders.entity.Order;

public interface OrderDAO {

	int create(Order order) throws SQLException;
	
	Order read(int id) throws SQLException;
	
	int update(Order order) throws SQLException;
	
	int delete(int id) throws SQLException;
	
	
	
}
