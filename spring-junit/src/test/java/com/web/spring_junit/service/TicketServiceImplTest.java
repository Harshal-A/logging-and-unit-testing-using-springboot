package com.web.spring_junit.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.web.spring_junit.dao.TicketDAO;
import com.web.spring_junit.entity.Ticket;

@ExtendWith(MockitoExtension.class)
class TicketServiceImplTest {

	private static final int INT_RESULT = 1;
	private static final String PHONE_NO = "12345";
	private static final String PASSENGER_NAME = "harshal";
	
	@Mock
	TicketDAO dao;
	
	@Autowired
	@InjectMocks
	TicketServiceImpl service;

	@Test
	public void buyTicket_shouldReturnAValidValue() {
		when(dao.createTicket(any(Ticket.class))).thenReturn(1);
		int result=service.buyTicket(PASSENGER_NAME, PHONE_NO);
		assertEquals(INT_RESULT, result);
	}

}
