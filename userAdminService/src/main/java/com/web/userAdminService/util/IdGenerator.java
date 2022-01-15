package com.web.userAdminService.util;

public final class IdGenerator {

	private static int i;
	
	public static int generateId() {
		return i++;
	}
}
