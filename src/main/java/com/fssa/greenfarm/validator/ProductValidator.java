package com.fssa.greenfarm.validator;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.greenfarm.exception.ProductInvalidException;
import com.fssa.greenfarm.model.Product;
import com.fssa.greenfarm.model.ProductValidatorErrors;

public class ProductValidator {

	// Method to checks the validity of the product
	public static boolean validate(Product product) throws ProductInvalidException {

		// It checks for the product if it is null or not
		// If the product is null it will throw an exception
		if (product == null) {
			throw new ProductInvalidException(ProductValidatorErrors.INVALID_PRODUCT_NULL);
		}
		validateProductName(product.getName());
		validateProductImageURL(product.getImageURL());
		validateProductDescription(product.getDescription());
		validateProductPercentage(product.getPercentage());
		validateProductPrice(product.getPrice());
		validateProductQuantity(product.getQuantity());
		return true;

	}

	// Method to check the valid product name
	public static boolean validateProductName(String name) throws ProductInvalidException {

		// ProductName should not be null
		// ProductNmae should not contain space
		// ProductName should have maximum length of 2
		if (name == null || "".equals(name.trim()) || name.length() < 2) {
			throw new ProductInvalidException(ProductValidatorErrors.INVALID_PRODUCT_NAME); 
		}
		return true;

	}

	// Method to check the valid product id
	public static boolean validateProductId(int id) throws ProductInvalidException {
		// ProductId cannot be less than or equal to 0
		// ProductId cannot more than 500
		if (id <= 0 || id > 500) {
			throw new ProductInvalidException(ProductValidatorErrors.INVALID_PRODUCT_ID);
		}
		return true;

	}

	// Method to check the valid product imageURL
	public static boolean validateProductImageURL(String imageURL) throws ProductInvalidException {
		// Product image URL cannot be empty or null
		// Product should have maximum length of 2
		if (imageURL == null || "".equals(imageURL.trim())) {
			throw new ProductInvalidException(ProductValidatorErrors.INVALID_PRODUCT_ImageURL);
		}
		String PATTERN = "(http)?s?:?(\\/\\/[^\"']*\\.(?:png|jpg|jpeg|gif|svg))";
		Pattern pattern = Pattern.compile(PATTERN);
		Matcher matcher = pattern.matcher(imageURL);
		// If it matches the above pattern it will return true otherwise else will
		// execute
		if (matcher.matches()) {
			return true;
		} else {
			throw new ProductInvalidException(ProductValidatorErrors.INVALID_PRODUCT_ImageURL);
		}

	}

	// Method to check the valid product price
	public static boolean validateProductPrice(double price) throws ProductInvalidException {
		// ProductPrice cannot be less than 10
		// ProductPrice cannot more than 5000
		if (price < 10 || price > 5000) {
			throw new ProductInvalidException(ProductValidatorErrors.INVALID_PRODUCT_PRICE);
		}
		return true;
	}

	// Method to check the valid product quantity
	public static boolean validateProductQuantity(double quantity) throws ProductInvalidException {
		// ProductQuantity cannot be equal to or less than 0
		// ProductPrice cannot more than 5000
		if (quantity <= 0 || quantity > 10.0) {
			throw new ProductInvalidException(ProductValidatorErrors.INVALID_PRODUCT_QUANTITY);
		}

		return true;

	}

	// Method to check the valid product percentage
	public static boolean validateProductPercentage(int percentage) throws ProductInvalidException {
		// Product percentage cannot be less than 5
		// Product percentage cannot more than 100
		if (percentage <= 5 || percentage >= 100) {
			throw new ProductInvalidException(ProductValidatorErrors.INVALID_PRODUCT_OFFER);
		}

		return true;

	}

	// Method to check the valid product description
	public static boolean validateProductDescription(String description) throws ProductInvalidException {
		// Product description cannot be null or empty
		// And also it should match the regular expression pattern
		if (description == null || "".equals(description.trim()) || description.length() < 30) {
			throw new ProductInvalidException(ProductValidatorErrors.INVALID_PRODUCT_DESCRIPTION);

		}
		String PATTERN = "^[a-zA-Z0-9 .,!?]+$";
		Pattern pattern = Pattern.compile(PATTERN);
		Matcher matcher = pattern.matcher(description);

		if (matcher.matches()) {
			return true;
		} else {
			throw new ProductInvalidException(ProductValidatorErrors.INVALID_PRODUCT_DESCRIPTION);
		}

	}

	// Method to check the valid product created date
	public static boolean validateProductCreatedDate(LocalDate createddate) throws ProductInvalidException {
		// product created date cannot be null and should be in the past
		LocalDate currentDate = LocalDate.now();
		if (createddate == null || createddate.isAfter(currentDate)) {
			throw new ProductInvalidException(ProductValidatorErrors.INVALID_PRODUCT_CREATED_DATE);
		}

		return true;
	}
}
