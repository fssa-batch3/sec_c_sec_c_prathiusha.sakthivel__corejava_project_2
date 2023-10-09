package com.fssa.greenfarm.service;

import java.sql.SQLException;

import com.fssa.greenfarm.DAO.UserDAO;
import com.fssa.greenfarm.exception.DAOException;
import com.fssa.greenfarm.exception.InvalidUserDetailException;
import com.fssa.greenfarm.model.User;
import com.fssa.greenfarm.validator.UserValidator;
import com.google.protobuf.ServiceException;

public class UserService {
	
	UserDAO userDAO = new UserDAO();
	private User user;

	public boolean userSignUp(User user) throws ServiceException {
	    try {
	        if (UserValidator.validateUser(user)) {
	            return userDAO.userRegistration(user);
	        }
	    } catch (InvalidUserDetailException | DAOException e) {
	        throw new ServiceException("Error during user sign-up: " + e.getMessage(), e);
	    }
	    return false;
	 
	}

 
	public boolean deleteUser(String emailId) throws ServiceException {
	    try {
	        if (!UserValidator.validateUserEmailId(emailId)) {
	            throw new InvalidUserDetailException("Invalid email format: " + emailId);
	        }

	        if (!userDAO.emailExists(emailId)) {
	            throw new ServiceException("Email Not Found: " + emailId);
	        }

	        return userDAO.deleteUser(emailId);
	    } catch (InvalidUserDetailException e) {
	        // Handle validation errors
	        throw new ServiceException(e.getMessage());
	    } catch (DAOException | SQLException e) {
	        // Handle database access errors
	        throw new ServiceException("Error while accessing the database: " + e.getMessage());
	    }
	}
	public boolean userLogin(String emailId, String password) throws ServiceException, InvalidUserDetailException, DAOException, SQLException {
	    if (userDAO.emailExists(emailId)) {
		    return userDAO.userLogin(emailId, password);
		} else {
		    return false;
		}
	    
	}


	public User getUserByEmail(String emailId) throws ServiceException, SQLException {
		try {
			if (UserValidator.validateUserEmailId(emailId)) {
				if (userDAO.emailExists(emailId)) {
					return userDAO.getUserByEmail(emailId);
				} else {
					throw new DAOException("User not found for email: " + emailId);
				}
			}
		} catch (InvalidUserDetailException | DAOException e) {
			throw new ServiceException(e.getMessage());
		}
		return null; // Invalid email format
	}

	public boolean updateUserProfile(User user) throws ServiceException, SQLException {
		try {
			if (UserValidator.validateUser(user)) {
				if (userDAO.emailExists(user.getEmail())) {
					return userDAO.updateUserProfile(user);
				} else {
					throw new DAOException("Email not found: " + user.getEmail());
				}
			}
		} catch (DAOException | InvalidUserDetailException e) {
			throw new ServiceException("Error updating user profile: " + e.getMessage());
		}
		return false;
	}
	

	public boolean updateUserDetails(User user) throws ServiceException, DAOException {
		
		System.out.print("in service layer");
		 if (userDAO.emailExists(user.getEmail())) 
			 return userDAO.updateUserDetails(user);
		return false;
			
		    
	        
	
	 
	}

	
}
