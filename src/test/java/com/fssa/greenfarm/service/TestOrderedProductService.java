package com.fssa.greenfarm.service;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.fssa.greenfarm.exception.DAOException;
import com.fssa.greenfarm.model.Order;

public class TestOrderedProductService {
	
	@Test
	 void testGetOrder() throws SQLException, DAOException {
		

		OrderedProductService orderedproductservices = new OrderedProductService();
		
		List<Order> productList = orderedproductservices.getOrderById(4);
		
		   for (Order product : productList) {
			   
		        System.out.println(product.toString()); 
		        
		    }

		
	}

}
