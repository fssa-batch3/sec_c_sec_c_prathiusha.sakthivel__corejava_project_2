package com.fssa.greenfarm.service;

import java.sql.SQLException;

import com.fssa.greenfarm.DAO.SellerDAO;
import com.fssa.greenfarm.exception.DAOException;
import com.fssa.greenfarm.exception.SellerInvalidException;
import com.fssa.greenfarm.model.Seller;
import com.fssa.greenfarm.validator.SellerValidator;
import com.google.protobuf.ServiceException;

public class SellerService {
	
	SellerDAO sellerDAO = new SellerDAO();

	public boolean sellerSignUp(Seller seller) throws SellerInvalidException, ServiceException {
	    try {
	        if (SellerValidator.validate(seller)) {
	            return sellerDAO.sellerRegistration(seller);
	        }
	    } catch (SellerInvalidException | DAOException e) {
	        throw new ServiceException("Error during user sign-up: " + e.getMessage(), e);
	    }
	    return false;
	 
	} 
 

	
	public boolean deleteSeller(String emailId) throws ServiceException,SellerInvalidException {
	    try {
	        if (!SellerValidator.validateEmail(emailId)) {
	            throw new SellerInvalidException("Invalid email format: " + emailId);
	        }

	        if (!sellerDAO.emailExists(emailId)) {
	            throw new ServiceException("Email Not Found: " + emailId);
	        }

	        return sellerDAO.deleteSeller(emailId);
	    } catch (SellerInvalidException e) {
	        // Handle validation errors
	        throw new ServiceException(e.getMessage());
	    } catch (DAOException | SQLException e) {
	        // Handle database access errors
	        throw new ServiceException("Error while accessing the database: " + e.getMessage());
	    }
	}
	
	
	public boolean sellerLogin(String emailId, String name) throws SellerInvalidException, DAOException, SQLException {
	    if (sellerDAO.emailExists(emailId)) {
		    return sellerDAO.sellerLogin(emailId, name);
		} else {
		    return false;
		}
	    
	}


	public  Seller getSellerrByEmail(String emailId) throws ServiceException, SellerInvalidException {
		try {
			if (SellerValidator.validateEmail(emailId)) {
				if (sellerDAO.emailExists(emailId)) {
					return sellerDAO.getSellerByEmail(emailId);
				} else {
					throw new DAOException("Seller not found for email: " + emailId);
				}
			}
		} catch (SellerInvalidException | DAOException e) {
			throw new ServiceException(e.getMessage());
		}
		return null; // Invalid email format
	}


}
