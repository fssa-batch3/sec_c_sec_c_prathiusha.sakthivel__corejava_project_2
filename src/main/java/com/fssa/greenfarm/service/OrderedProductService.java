package com.fssa.greenfarm.service;

import java.sql.SQLException;
import java.util.List;

import com.fssa.greenfarm.DAO.OrderedProductDAO;
import com.fssa.greenfarm.exception.DAOException;
import com.fssa.greenfarm.model.Order;

public class OrderedProductService {

	
	public  List<Order> getOrderById(int id) 
			throws SQLException, DAOException {

		return OrderedProductDAO.getOrderById(id);
	}
	
	public List<Order> getAllOrderedProduct(int userId) throws SQLException, DAOException {
		return OrderedProductDAO.getOrderById(userId); 

	}
}
