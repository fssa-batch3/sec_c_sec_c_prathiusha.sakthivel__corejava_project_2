package com.fssa.greenfarm.validator;

import com.fssa.greenfarm.customerrors.CartValidatorErrors;
import com.fssa.greenfarm.exception.InvalidCartDetailException;
import com.fssa.greenfarm.model.CartItems;

public class CartValidator {
	public static boolean validateCartItems(CartItems cartItems)  throws InvalidCartDetailException {

		// It checks for the product if it is null or not
		// If the product is null it will throw an exception
		if (cartItems == null) {
			throw new InvalidCartDetailException(CartValidatorErrors.INVALID_CARTITEMS);
		}
		validateCart_Id(cartItems.getCart_id());
		validateUser_Id(cartItems.getUser_id());
		validateProduct_Id(cartItems.getProduct_id());
		validateTotalPrice(cartItems.getTotalprice());
		validateQuantity(cartItems.getQuantity());
		validateStatus(cartItems.getStatus());

		return true;

	}

	private static void validateStatus(boolean status) throws InvalidCartDetailException {
		if (!status) {
			throw new InvalidCartDetailException(CartValidatorErrors.INVALID_STATUS);
		}

	}

	private static void validateQuantity(float quantity) throws InvalidCartDetailException {
		if (quantity <= 0) {
			throw new InvalidCartDetailException(CartValidatorErrors.INVALID_QUANTITY);
		}

	}

	private static void validateTotalPrice(float totalprice) throws InvalidCartDetailException {
		if (totalprice < 0) {
			throw new InvalidCartDetailException(CartValidatorErrors.INVALID_TOTALPRICE);
		}

	}

	private static void validateProduct_Id(int product_id) throws InvalidCartDetailException {
		if (product_id <= 0) {
			throw new InvalidCartDetailException(CartValidatorErrors.INVALID_PRODUCT_ID);
		}
	}

	private static void validateUser_Id(int user_id) throws InvalidCartDetailException {
		if (user_id <= 0) {
			throw new InvalidCartDetailException(CartValidatorErrors.INVALID_USER_ID);
		}

	}

	private static void validateCart_Id(int cart_id) throws InvalidCartDetailException {
		if (cart_id <= 0) {
			throw new InvalidCartDetailException(CartValidatorErrors.INVALID_CART_ID);
		}
	}

}
