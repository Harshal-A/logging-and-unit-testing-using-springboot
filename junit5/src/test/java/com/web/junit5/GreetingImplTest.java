package com.web.junit5;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class GreetingImplTest {
	
	@Mock
	private GreetingService service;
	
	@InjectMocks
	private GreetingImpl greeting;
	

	@Test
	public void greetShouldReturnValidOutput() {	
		when(service.greet("junit")).thenReturn("Hello junit");
		String result=greeting.greet("junit");
		Assertions.assertNotNull(result);
		Assertions.assertEquals("Hello junit", result);
	}

	@Test
	public void greetShouldThrowAnExceptionForNameIsNull() {
		when(service.greet(null)).thenThrow(IllegalArgumentException.class);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			greeting.greet(null);
		});
		
	}
	
	@Test
	public void greetShouldThrowAnExceptionForNameIsBlank() {
		doThrow(IllegalArgumentException.class).when(service).greet("");
//		when(service.greet("")).thenThrow(IllegalArgumentException.class);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			greeting.greet("");
		});
	}
}
