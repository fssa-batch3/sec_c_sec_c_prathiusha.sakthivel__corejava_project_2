package com.fssa.greenfarm.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.fssa.greenfarm.exception.DAOException;

public class ConnectionUtil {
	ConnectionUtil() {
		// Private constructor to prevent instantiation
	}

	/**
	 * Get a connection to the database.
	 * 
	 * @return The database connection.
	 * @throws DAOException
	 * @throws RuntimeException if unable to connect to the database.
	 */
	public static Connection getConnection() throws DAOException {
		String url;
		String userName;
		String passWord;
		Connection con = null;

//		url = System.getenv("DATABASE_HOST");
//		userName = System.getenv("DATABASE_USERNAME");
//		passWord = System.getenv("DATABASE_PASSWORD");

		url ="jdbc:mysql://164.52.216.41:3306/prathiusha_sakthivel_corejava_project";
		userName = "rAEOkZgfhu14";
		passWord = "863b6f35-efaa-428b-8c77-b01f0c9111d0";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, userName, passWord);
//			Logger.info("Connection success");

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Unable to connect to the database");
		}

		return con;

	}

	public static void close(Connection conn, Statement stmt, PreparedStatement ps, ResultSet rs) throws DAOException {
		try {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			throw new DAOException("Unable to close to the database");

		}
	}

	public static void main(String[] args) throws DAOException {
		ConnectionUtil.getConnection();
	}
}
