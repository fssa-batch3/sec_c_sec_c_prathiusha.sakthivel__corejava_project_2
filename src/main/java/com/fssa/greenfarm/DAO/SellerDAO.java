package com.fssa.greenfarm.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.fssa.greenfarm.exception.DAOException;
import com.fssa.greenfarm.model.Seller;

public class SellerDAO {

	public boolean sellerRegistration(Seller seller) throws DAOException {

		try (Connection connection = ProductConnection.getConnection()) {

			String insertQuery = "INSERT INTO Seller (seller_name, seller_ownershiptype, seller_gender, seller_email,seller_address,seller_district,seller_state,seller_bankname,seller_branchname,seller_category,seller_farmimage,seller_feedback) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

			try (PreparedStatement psmt = connection.prepareStatement(insertQuery)) {
 
				psmt.setString(1, seller.getName());
				psmt.setObject(2, seller.getOwnershipType());
				psmt.setObject(3, seller.getGender());
				psmt.setString(4, seller.getEmail());
				psmt.setString(5, seller.getAddress());
				psmt.setString(6, seller.getDistrict());
				psmt.setString(7, seller.getState());
				psmt.setString(8, seller.getBankname());
				psmt.setString(9, seller.getBranchname());
				psmt.setObject(10, seller.getCategory());
				psmt.setString(11, seller.getFarmimage());
				psmt.setString(12, seller.getFeedback());

				psmt.executeUpdate();
				 


				return true;

			} catch (SQLException e) {
				// Handle any SQLException that may occur during PreparedStatement execution
				throw new DAOException("Error while executing the insert query: " + e.getMessage(), e);
			}
		} catch (SQLException e) {
			// Handle any SQLException that may occur during database connection
			throw new DAOException("Error while connecting to the database: " + e.getMessage(), e);
		}

	}
	
	
	
	public boolean deleteSeller(String emailId) throws DAOException, SQLException {
		
		try (Connection connection = ProductConnection.getConnection()) {

			String deleteQuery = "DELETE FROM Seller WHERE seller_email = ?";
			
			try (PreparedStatement psmt = connection.prepareStatement(deleteQuery)) {

				psmt.setString(1, emailId);
				
				int rowAffected = psmt.executeUpdate();
				
				return rowAffected > 0;
			}
		}
	}
	public boolean emailExists(String emailId) throws DAOException {
		
	    try (Connection connection = ProductConnection.getConnection();
	    		
	         PreparedStatement psmt = connection.prepareStatement("SELECT seller_id FROM Seller WHERE seller_email = ?")) {
	        
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

	
	public boolean sellerLogin(String emailId, String name) throws DAOException, SQLException {
		
		try (Connection connection = ProductConnection.getConnection()) {
			
			String selectQuery = "SELECT COUNT(*) FROM Seller WHERE seller_email = ? AND seller_name = ?";
			
			try (PreparedStatement psmt = connection.prepareStatement(selectQuery)) {
				
				psmt.setString(1, emailId);
				psmt.setString(2, name);

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
	

	public Seller getSellerByEmail(String emailId) throws DAOException {

		try (Connection connection = ProductConnection.getConnection()) {

			String selectQuery = "SELECT seller_name, seller_ownershiptype, seller_gender,seller_address,seller_district,seller_state,seller_bankname,seller_branchname,seller_category,seller_farmimage,seller_feedback FROM Seller WHERE seller_email = ?";
			try (PreparedStatement psmt = connection.prepareStatement(selectQuery)) {
				psmt.setString(1, emailId);

				try (ResultSet rs = psmt.executeQuery()) {
					if (rs.next()) {
						Seller seller = new Seller();
//						user.setUser_id(rs.getInt("user_id"));
						seller.setName(rs.getString("seller_name"));
						seller.setName(rs.getString("seller_address"));
						seller.setName(rs.getString("seller_district"));
						seller.setName(rs.getString("seller_state"));
						seller.setName(rs.getString("seller_bankname"));
						seller.setName(rs.getString("seller_branchname"));
						seller.setName(rs.getString("seller_farmimage"));
						seller.setName(rs.getString("seller_feedback"));
						
						return seller;
					}
				}
			}
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}
		return null; // User not found
	}


}
