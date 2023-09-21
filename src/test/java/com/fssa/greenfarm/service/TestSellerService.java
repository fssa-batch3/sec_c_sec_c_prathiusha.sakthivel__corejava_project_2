package com.fssa.greenfarm.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.SQLException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.greenfarm.exception.DAOException;
import com.fssa.greenfarm.exception.SellerInvalidException;
import com.fssa.greenfarm.model.Seller;
import com.google.protobuf.ServiceException;

public class TestSellerService {

	
	    @Test
	    public void testSellerSignUp() throws SellerInvalidException, ServiceException {
		    SellerService sellerService = new SellerService();
	        Seller seller = new Seller();
	        seller.setName("Varshini");
	        seller.setOwnershipType("Partnership");
	        seller.setGender("Female");
	        seller.setEmail("varshini2244@example.com");
	        seller.setAddress("123 Main St");
	        seller.setDistrict("Chennai");
	        seller.setState("Tamil nadu"); 
	        seller.setBankname("CUB");
	        seller.setBranchname("Chennai");
	        seller.setCategory("Vegetables");
	        seller.setFarmimage("www.jpg");
	        seller.setFeedback("feeling very excited and proud to sell in this website");

	        assertTrue(sellerService.sellerSignUp(seller));
	    } 
	    

	    @Test
	    void testSellerSignUpInvalidSellerName() {
	    	SellerService sellerService = new SellerService();
		    Seller seller = new Seller();
		    seller.setName(null);
	        assertThrows(ServiceException.class, () -> sellerService.sellerSignUp(seller));
	    }

	    
  
	    @Test
	    void testValidSellerLogin() throws ServiceException, SellerInvalidException, DAOException, SQLException {
	    	SellerService sellerService = new SellerService();
	    	Assertions.assertTrue(sellerService.sellerLogin("varshini@example.com", "Varshini"));
	    }

	    @Test
	    void testSellerLoginInvalidInput() {
	    	SellerService sellerService = new SellerService();
	        assertThrows(ServiceException.class, () -> sellerService.sellerLogin("", "weakPassword"));
	    }

	 

	    @Test
	    void testDeleteSellerValidInput() {
	    	SellerService sellerService = new SellerService();
	        assertDoesNotThrow(() -> sellerService.deleteSeller("varshini@example.com"));
	    }

	    @Test
	    void testDeleteSellerrInvalidInput() {
	    	SellerService sellerService = new SellerService();
	        assertThrows(ServiceException.class, () -> sellerService.deleteSeller("email@gmail.com"));
	    }

}
