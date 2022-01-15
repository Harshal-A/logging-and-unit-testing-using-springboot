package com.web.orders.bo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

import java.sql.SQLException;

import com.web.orders.dao.OrderDAO;
import com.web.orders.entity.Order;
import com.web.orders.exception.BOException;

class OrderBOImplTest {
	
	@Mock
	private OrderDAO dao;
	
	private OrderBOImpl bo;
	
	private static final int ORDER_ID=123;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
		bo=new OrderBOImpl();
		bo.setOrderDAO(dao);
	}
	
	@Test
	public void placeOrder_ShouldCreateAnOrder() throws SQLException {
		Order order=new Order();
		when(dao.create(order)).thenReturn(1);
		
		boolean result=bo.placeOrder(order);
		
		assertTrue(result);
		verify(dao).create(order);
	}
	
	
	@Test
	public void placeOrder_ShouldNotCreateAnOrder() throws SQLException {
		
		Order order=new Order();
		when(dao.create(order)).thenReturn(0);
		
		boolean result=bo.placeOrder(order);
		
		assertFalse(result);
		verify(dao).create(order);
	}
	
	
	@Test
	public void placeOrder_ShouldThrowBOException() throws SQLException {
		
		Order order=new Order();
		when(dao.create(order)).thenThrow(SQLException.class);
		Assertions.assertThrows(BOException.class, () -> {
			bo.placeOrder(order);
		});
		
	}
	
	@Test
	public void cancelOrder_ShouldCancelOrder() throws SQLException {
		
		Order order=new Order();
		when(dao.read(ORDER_ID)).thenReturn(order);
		when(dao.update(order)).thenReturn(1);
		boolean result=bo.cancelOrder(ORDER_ID);
		assertTrue(result);
		
		verify(dao).read(ORDER_ID);
		verify(dao).update(order);
	}
	
	@Test
	public void cancelOrder_ShouldNotCancelOrder() throws SQLException {
		
		Order order=new Order();
		when(dao.read(ORDER_ID)).thenReturn(order);
		when(dao.update(order)).thenReturn(0);
		boolean result=bo.cancelOrder(ORDER_ID);
		assertFalse(result);
		
		verify(dao).read(ORDER_ID);
		verify(dao).update(order);
	}
	
	@Test
	public void cancelOrder_ShouldthrowBOExceptionOnRead() throws SQLException {
		
		Order order=new Order();
		when(dao.read(ORDER_ID)).thenThrow(SQLException.class);
		Assertions.assertThrows(BOException.class, ()->{
			bo.cancelOrder(ORDER_ID);
		});
		
	}
	
	
	@Test
	public void cancelOrder_ShouldthrowBOExceptionOnUpdate() throws SQLException {
		
		Order order=new Order();
		when(dao.read(ORDER_ID)).thenReturn(order);
		when(dao.update(order)).thenThrow(SQLException.class);
		Assertions.assertThrows(BOException.class, ()->{
			bo.cancelOrder(ORDER_ID);
		});
		
	}
	
	@Test
	public void deleteOrder_ShouldDeleteOrder() throws SQLException {
		
		Order order=new Order();
		when(dao.delete(ORDER_ID)).thenReturn(1);
		boolean result=bo.deleteOrder(ORDER_ID);
		assertTrue(result);
		
		verify(dao).delete(ORDER_ID);
	}
	
	@Test
	public void deleteOrder_ShouldNotDeleteOrder() throws SQLException {
		
		Order order=new Order();
		when(dao.delete(ORDER_ID)).thenReturn(0);
		boolean result=bo.deleteOrder(ORDER_ID);
		assertFalse(result);
		
		verify(dao).delete(ORDER_ID);
	}
	
	@Test
	public void deleteOrder_ShouldThrowBOException() throws SQLException {
		
		Order order=new Order();
		when(dao.delete(ORDER_ID)).thenThrow(SQLException.class);
		Assertions.assertThrows(BOException.class, ()->{
			bo.deleteOrder(ORDER_ID);
		});
	}


}
