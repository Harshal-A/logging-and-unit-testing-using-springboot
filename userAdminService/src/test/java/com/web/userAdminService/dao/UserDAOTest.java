package com.web.userAdminService.dao;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.*;


import org.junit.jupiter.api.Test;
import org.powermock.core.classloader.annotations.PrepareForTest;

import com.web.userAdminService.dto.User;
import com.web.userAdminService.util.IdGenerator;


@PrepareForTest(IdGenerator.class)
class UserDAOTest {

	@Test
	public void create_shouldReturnTheUserIdBack() {
		UserDAO userDAO=new UserDAO();
		mockStatic(IdGenerator.class);
		when(IdGenerator.generateId()).thenReturn(1);
		int result=userDAO.create(new User());
		assertEquals(1,result );
		verifyStatic(IdGenerator.class);
	}

}
