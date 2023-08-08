package com.fssa.greenfarm.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import io.github.cdimascio.dotenv.Dotenv;

public class ProductConnection {
	
	 public static Connection getConnection() {
	        Connection con = null;

	        String url;
	        String userName;
	        String passWord;

	        if (System.getenv("CI") != null) {
	            url = System.getenv("DATABASE_HOST");
	            userName = System.getenv("DATABASE_USERNAME");
	            passWord = System.getenv("DATABASE_PASSWORD");
	        } else {
	            Dotenv env = Dotenv.load();
	            url = env.get("DATABASE_HOST");
	            userName = env.get("DATABASE_USERNAME");
	            passWord = env.get("DATABASE_PASSWORD");
	        }

	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            con = DriverManager.getConnection(url, userName, passWord);
	            System.out.println("connected");
	        } catch (Exception e) {
	            e.printStackTrace();
	            throw new RuntimeException("Unable to connect to the database");
	        }
	        return con;
	    }

//	public static Connection getConnection() {
//		Connection connection = null;
//		String url = "jdbc:mysql://localhost:3306/GreenFarm";
//		String userName = "root";
//		String password = "123456";
//
//		try {
//			connection = DriverManager.getConnection(url, userName, password);
//		} catch (Exception e) {
//
//			e.printStackTrace();
//
//			throw new RuntimeException("Unable to connect to the database");
//		}
//
//		return connection;
//	}

	
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
	
	public static void main(String[] args) {
		getConnection();
	}

}

