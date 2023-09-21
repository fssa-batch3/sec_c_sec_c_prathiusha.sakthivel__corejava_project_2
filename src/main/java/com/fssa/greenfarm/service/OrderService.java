package com.fssa.greenfarm.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.fssa.greenfarm.DAO.OrderDAO;
import com.fssa.greenfarm.exception.DAOException;
import com.fssa.greenfarm.exception.InValidOrderDetailException;
import com.fssa.greenfarm.model.Order;
import com.fssa.greenfarm.validator.OrderValidator;
import com.google.protobuf.ServiceException;

public class OrderService {

	OrderDAO orderDAO = new OrderDAO();

	public boolean createOrder(Order order) throws InValidOrderDetailException, ServiceException {
		try {
			if (OrderValidator.validate(order)) {
				 return orderDAO.createOrder(order);
			}
		} catch (InValidOrderDetailException | DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return false;

	}
	
	public static ArrayList<Order> getOrderById(int orderId) throws DAOException, SQLException {

		OrderDAO orderDao = new OrderDAO();
		return orderDao.getOrderById(orderId);

	}

}
