package com.fssa.greenfarm.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.fssa.greenfarm.DAO.CartDAO;
import com.fssa.greenfarm.exception.DAOException;
import com.fssa.greenfarm.model.CartItems;

public class CartService {

	public static void addToCart(CartItems cart) throws DAOException, SQLException {

		CartDAO.addToCart(cart);

	}

	public static void addingCartItems(ArrayList<CartItems> cartDetails, int cartId) throws DAOException, SQLException {
		CartDAO.addingCartItems(cartDetails, cartId);
	}

	public static ArrayList<CartItems> getCartItemsByUserId(int userid) throws DAOException, SQLException {
		return CartDAO.getCartItemsByUserId(userid);
	}

	public static void removeCartByCartId(int cartId) throws DAOException, SQLException {
		CartDAO.removeCartItemsByCartId(cartId);
	}

	public static void increaseQuantity(int cartId) {
		
	}

}
