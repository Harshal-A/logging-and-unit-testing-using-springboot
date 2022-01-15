package com.bharath.junit;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.sun.org.apache.xpath.internal.operations.String;

@ExtendWith(MockitoExtension.class)
class CouponServletTest {
	
	@Mock
	private HttpServletRequest request;
	
	@Mock
	private HttpServletResponse response;
	
	@Mock
	private RequestDispatcher dispatch;

	@Test
	public void doGet() throws ServletException, IOException {
		
		StringWriter Stringwriter=new StringWriter();
		PrintWriter printWriter=new PrintWriter(Stringwriter);
		when(response.getWriter()).thenReturn(printWriter);
		new CouponServlet().doGet(request, response);
		assertEquals("SUPERSALE", Stringwriter.toString());

		
	}

	@Test
	void doPost() throws ServletException, IOException {
		when(request.getParameter("coupon")).thenReturn("SUPERSALE");
		when(request.getRequestDispatcher("response.jsp")).thenReturn(dispatch);
		new CouponServlet().doPost(request, response);
		verify(request).setAttribute("discount", "Discount for coupon SUPERSALE is 50%");
		verify(dispatch).forward(request, response);
		
	}

}
