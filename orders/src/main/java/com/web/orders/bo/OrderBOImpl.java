package com.web.orders.bo;

import java.sql.SQLException;

import com.web.orders.dao.OrderDAO;
import com.web.orders.entity.Order;
import com.web.orders.exception.BOException;

public class OrderBOImpl implements OrderBO {
	
	private OrderDAO orderDAO;
	


	public void setOrderDAO(OrderDAO orderDAO) {
		this.orderDAO = orderDAO;
	}

	public boolean placeOrder(Order order) throws BOException {
		try {
			int result=orderDAO.create(order);
			if(result==0) {
				return false;
			}
		} catch (SQLException e) {
			throw new BOException(e);
		}
		return true;
	}

	public boolean cancelOrder(int id) throws BOException {
		try {
			Order order=orderDAO.read(id);
			order.setStatus("cancel");
			int result=orderDAO.update(order);
			if(result==0) {
				return false;
			}
		} catch (SQLException e) {
			throw new BOException(e);
		}
		return true;
	}

	public boolean deleteOrder(int id) throws BOException {
		try {
			int result=orderDAO.delete(id);
			if(result==0) {
				return false;
			}

		} catch (SQLException e) {
			throw new BOException(e);
		}
		return true;
	}


}
