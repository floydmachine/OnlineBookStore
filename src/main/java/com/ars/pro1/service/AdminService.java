package com.ars.pro1.service;

import java.sql.SQLException;

public interface AdminService {
	public boolean isValidUser(String username, String password)
			throws SQLException;
}
