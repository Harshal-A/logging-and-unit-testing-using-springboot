package com.web.orders.exception;

import java.sql.SQLException;

public class BOException extends RuntimeException {

	public BOException(SQLException e) {
		super(e);
	}



}
