package com.web.spring_junit.dao;

import org.springframework.stereotype.Repository;

import com.web.spring_junit.entity.Ticket;

@Repository
public class TicketDAOImpl implements TicketDAO {

	public int createTicket(Ticket ticket) {
		return 1;
	}

}
