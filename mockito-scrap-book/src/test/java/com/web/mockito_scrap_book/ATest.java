package com.web.mockito_scrap_book;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ATest {

	@Mock
	private B b;
	
	@InjectMocks
	private A a;
	
	@Test
	void usesVoidMethodShouldCallVoidMethod() throws Exception {
		doNothing().when(b).voidMethod();
		Assertions.assertSame(1, a.usesVoidMethod());
		verify(b).voidMethod();
	
	}
	
	@Test
	void usesVoidMethodShouldThrowException() throws Exception {
		doNothing().doThrow(Exception.class).when(b).voidMethod();
		a.usesVoidMethod();
		verify(b).voidMethod();
		Assertions.assertThrows(RuntimeException.class, ()->{
			a.usesVoidMethod();
		});
		verify(b,times(2)).voidMethod();
	}

}
