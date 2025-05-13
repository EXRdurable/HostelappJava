package com.hostelapp.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConfig {

	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/hostelapp";
	private static final String JDBC_USER = "root";
	private static final String JDBC_PASSWORD = "";

	public static Connection getConnection() throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
		} catch (ClassNotFoundException e) {
			throw new SQLException("JDBC Driver not found.", e);

		}
	}
}
