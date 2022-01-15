package com.web.userAdminService.dao;

import com.web.userAdminService.dto.User;
import com.web.userAdminService.util.IdGenerator;

public class UserDAO {

	public int create(User user) {
		int id=IdGenerator.generateId();
		return id;
	}
}
