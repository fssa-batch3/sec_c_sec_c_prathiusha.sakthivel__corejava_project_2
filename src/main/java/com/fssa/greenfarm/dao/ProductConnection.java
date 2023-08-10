 package com.fssa.greenfarm.dao;
 
import java.sql.Connection;
import java.sql.DriverManager;
import com.fssa.greenfarm.exception.DAOException;
import io.github.cdimascio.dotenv.Dotenv;

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
 
	        try {// 
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            con = DriverManager.getConnection(url, userName, passWord);
	        } catch (Exception e) {
	            throw new DAOException("Unable to connect to the database");
	        }
	        return con;   
	     
	    }
} 


