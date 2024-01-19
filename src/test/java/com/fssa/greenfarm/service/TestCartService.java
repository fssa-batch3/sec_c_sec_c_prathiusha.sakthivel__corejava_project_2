package com.fssa.greenfarm.service;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.fssa.greenfarm.DAO.CartDAO;
import com.fssa.greenfarm.exception.DAOException;
import com.fssa.greenfarm.model.CartItems;

public class TestCartService {

	@Test
	public void testAddItemToCart() throws DAOException, SQLException {
		CartDAO cartDAO = new CartDAO();
		CartItems cartItem = new CartItems();
		cartItem.setCart_id(96);
		cartItem.setUser_id(1);
		cartItem.setProduct_id(100);
		cartItem.setTotalprice(50.0f);
		cartItem.setQuantity(2.5f);
		cartItem.setStatus(true);
		
		cartDAO.addToCart(cartItem);

	}

}
