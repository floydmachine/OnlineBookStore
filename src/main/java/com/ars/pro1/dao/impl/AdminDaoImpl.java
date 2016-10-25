package com.ars.pro1.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ars.pro1.dao.AdminDao;

@Repository
public class AdminDaoImpl implements AdminDao {

	@Autowired
	DataSource dataSource;

	@Override
	public boolean isValidUser(String username, String password)
			throws SQLException {
		String query = "Select count(1) from Admin where username = ? and password = ?";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setString(1, username);
		pstmt.setString(2, password);
		ResultSet resultSet = pstmt.executeQuery();
		if (resultSet.next())
			return (resultSet.getInt(1) > 0);
		else
			return false;
	}
}
