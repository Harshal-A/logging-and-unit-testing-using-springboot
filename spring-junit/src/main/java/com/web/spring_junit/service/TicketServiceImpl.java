package com.web.spring_junit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.spring_junit.dao.TicketDAO;
import com.web.spring_junit.entity.Ticket;
@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	private TicketDAO dao;
	
	public int buyTicket(String passengerName, String phone) {
		Ticket ticket=new Ticket();
		ticket.setPassengerName(passengerName);
		ticket.setPhone(phone);
		dao.createTicket(ticket);
		return 1;
	}

}
