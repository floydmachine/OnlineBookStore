package com.ars.pro1.service.impl;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ars.pro1.dao.AdminDao;
import com.ars.pro1.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDao adminDao;

	@Override
	public boolean isValidUser(String username, String password)
			throws SQLException {
		return adminDao.isValidUser(username, password);
	}

}
