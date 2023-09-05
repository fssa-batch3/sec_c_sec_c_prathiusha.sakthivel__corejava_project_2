package com.fssa.greenfarm.DAO;

import java.sql.Connection;
import java.sql.DriverManager;

import com.fssa.greenfarm.exception.DAOException;

public class ProductConnection {
	private ProductConnection() {
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

		url = System.getenv("DATABASE_HOST");
		userName = System.getenv("DATABASE_USERNAME");
		passWord = System.getenv("DATABASE_PASSWORD");

		try {//
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, userName, passWord);
			System.out.println("Connection success");
		} catch (Exception e) {
			throw new DAOException("Unable to connect to the database");
		}
		return con;

	}

	public static void main(String[] args) {

		try {
			getConnection();
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}
}
