package com.fssa.greenfarm.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductConnection {
	public static Connection getConnection() {
		Connection connection = null;
		String url = "jdbc:mysql://localhost:3306/GreenFarm";
		String userName = "root";
		String password = "123456";

		try {
			connection = DriverManager.getConnection(url, userName, password);
		} catch (Exception e) {

			e.printStackTrace();

			throw new RuntimeException("Unable to connect to the database");
		}

		return connection;
	}

	
	// method for closing the connection

	public static void close(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
