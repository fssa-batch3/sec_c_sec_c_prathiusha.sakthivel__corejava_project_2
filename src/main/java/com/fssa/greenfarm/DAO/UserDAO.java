package com.fssa.greenfarm.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.fssa.greenfarm.exception.DAOException;
import com.fssa.greenfarm.logger.Logger;
import com.fssa.greenfarm.model.User;
import com.fssa.greenfarm.util.ConnectionUtil;

public class UserDAO {

	public boolean userRegistration(User user) throws DAOException {
	    try (Connection connection = ConnectionUtil.getConnection()) {
	        String insertQuery = "INSERT INTO User (firstname, lastname, email_id, password) VALUES (?, ?, ?, ?)";
	        try (PreparedStatement psmt = connection.prepareStatement(insertQuery)) {
	            psmt.setString(1, user.getFirstname());
	            psmt.setString(2, user.getLastname());
	            psmt.setString(3, user.getEmail());
	            psmt.setString(4, user.getPassword());
  
	            int rowsAffected = psmt.executeUpdate();
	            return rowsAffected > 0;
	        } catch (SQLException e) { 
	            // Handle any SQLException that may occur during PreparedStatement execution
	            throw new DAOException("Error while executing the insert query: " + e.getMessage(), e);
	        }
	    } catch (SQLException e) {
	        // Handle any SQLException that may occur during database connection
	        throw new DAOException("Error while connecting to the database: " + e.getMessage(), e);
	    }
	}


	public boolean deleteUser(String emailId) throws DAOException, SQLException {
		
		try (Connection connection = ConnectionUtil.getConnection()) {

			String deleteQuery = "DELETE FROM User WHERE email_id = ?";
			
			try (PreparedStatement psmt = connection.prepareStatement(deleteQuery)) {

				psmt.setString(1, emailId);
				int rowAffected = psmt.executeUpdate();
				return rowAffected > 0;
			}
		}
	}
	public boolean emailExists(String emailId) throws DAOException {
	    try (Connection connection = ConnectionUtil.getConnection();
			 PreparedStatement psmt = connection.prepareStatement("SELECT user_id FROM User WHERE email_id = ?")) {
	        
	        psmt.setString(1, emailId);

	        try (ResultSet rs = psmt.executeQuery()) {
	            if (rs.next()) {
	                // If a row with the given email exists, return true
	                return true;
	            }
	        } catch (SQLException e) {
	            // Handle any SQLException that may occur during result set processing
	            throw new DAOException("Error while processing the result set: " + e.getMessage(), e);
	        }
	    } catch (SQLException e) {
	        // Handle any SQLException that may occur during database connection or statement creation
	        throw new DAOException("Error while checking email existence: " + e.getMessage(), e);
	    }

	    // If no matching email was found, return false
	    return false;
	}

	
	public boolean userLogin(String emailId, String password) throws DAOException, SQLException {
		
		try (Connection connection = ConnectionUtil.getConnection()) {
			
			String selectQuery = "SELECT COUNT(*) FROM User WHERE email_id = ? AND password = ?";
			
			try (PreparedStatement psmt = connection.prepareStatement(selectQuery)) {
				psmt.setString(1, emailId);
				psmt.setString(2, password);

				try (ResultSet rs = psmt.executeQuery()) {
					if (rs.next()) {
						int count = rs.getInt(1);
						return count==1 ; // Return true if count is greater than 0 (successful login)
					}
				}
			}
		} catch (SQLException e) {
			throw new DAOException("Error while checking login for email: " + emailId, e);
		}

		// Return false if no user with the given email and password was found
		return false;
	}

	
	public User getUserByEmail(String emailId) throws DAOException {

		try (Connection connection = ConnectionUtil.getConnection()) {

			String selectQuery = "SELECT user_id, firstname, lastname, password,city,state,address,pincode,mobilenumber FROM User WHERE email_id = ?";
			try (PreparedStatement psmt = connection.prepareStatement(selectQuery)) {
				psmt.setString(1, emailId);

				try (ResultSet rs = psmt.executeQuery()) {
					if (rs.next()) {
						User user = new User();
						user.setUser_id(rs.getInt("user_id"));
						user.setFirstname(rs.getString("firstname"));
						user.setLastname(rs.getString("lastname"));
						user.setPassword(rs.getString("password"));
						user.setCity(rs.getString("city"));
						user.setState(rs.getString("state"));
						user.setAddress(rs.getString("address"));
						user.setPincode(rs.getInt("pincode"));;
						user.setMobilenumber(rs.getLong("mobilenumber"));
						user.setEmail(emailId);
						return user;
					}
				} 
			}
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}
		return null; // User not found
	}

	public boolean updateUserProfile(User user) throws DAOException {
		String updateQuery = "UPDATE User SET firstname = ?,lastname = ?, password = ? WHERE email_id = ?";
		try (Connection connection = ConnectionUtil.getConnection();

			 PreparedStatement psmt = connection.prepareStatement(updateQuery)) {

			psmt.setString(1, user.getFirstname());
			psmt.setString(2, user.getLastname());
			psmt.setString(3, user.getPassword());

			int rowsUpdated = psmt.executeUpdate();

			return rowsUpdated > 0;

		} catch (SQLException e) {
			throw new DAOException("Error updating user profile: " + e.getMessage());
		}
	}
	
	public static int getUserIdByEmail(String email) throws DAOException {
		int userId = -1; // Default value if the email is not found or an error occurs.

		try (Connection con = ConnectionUtil.getConnection()) {
			// SQL query to retrieve the user ID by email.
			String query = "SELECT user_id FROM User WHERE email_id=?";

			try (PreparedStatement psmt = con.prepareStatement(query)) {
				
				// Set the email parameter in the PreparedStatement.
				psmt.setString(1, email);

				try (ResultSet rs = psmt.executeQuery()) {
					if (rs.next()) {
						userId = rs.getInt("user_id");
					}
				}
			}
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}

		return userId;
	}
	
	
	public boolean updateUserDetails(User user) throws DAOException {

		try (Connection con = ConnectionUtil.getConnection()) {
			

			final String query = "UPDATE User SET address=?, city=?, state=?, pincode=?, mobilenumber=? WHERE email_id=?";
			
			try (PreparedStatement pst = con.prepareStatement(query)) {

				pst.setString(1, user.getAddress());
				pst.setString(2, user.getCity());
				pst.setString(3, user.getState());
				pst.setInt(4, user.getPincode());
				pst.setLong(5, user.getMobilenumber());
				pst.setString(6, user.getEmail());
				int rs = pst.executeUpdate();
				
				if (rs > 0) {
				    Logger.info("User Details Updated Successfully");
				    return true;
				} else {
				    Logger.info("User Details Update Failed");
				    return false;
				}
			}

		} catch (SQLException ex) {
			throw new DAOException("Update User Details Method Is Failed " + ex.getMessage());
		}

	}
	
}
