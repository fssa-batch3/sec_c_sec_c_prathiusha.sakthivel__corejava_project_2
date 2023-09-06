package com.fssa.greenfarm.customerrors;

//Interface is used to track Exceptions
public interface ProductValidatorErrors {

	// this custom exception is thrown when a product is null
	public static final String INVALID_PRODUCT_NULL = "Product cannot be null";

	// this custom exception is thrown when a product name is invalid
	public static final String INVALID_PRODUCT_NAME = "Product name cannot be null or empty";

	// this custom exception is thrown when a product id is invalid
	public static final String INVALID_PRODUCT_ID = "Product id cannot be less than or equal to 0 and cannot more than 500";

	// this custom exception is thrown when a product ImageURL is invalid
	public static final String INVALID_PRODUCT_ImageURL = "Product image URL cannot be null or empty";

	// this custom exception is thrown when a product price is invalid
	public static final String INVALID_PRODUCT_PRICE = "Product price cannot be less than or equal to 10 and cannot more than 5000";

	// this custom exception is thrown when a product offer is invalid
	public static final String INVALID_PRODUCT_OFFER = "Product offer percentage cannot be 0 or less than that and cannot more than 100";

	// this custom exception is thrown when a product quantity is invalid
	public static final String INVALID_PRODUCT_QUANTITY = "Product quantity cannot be less than or equal to 0 and cannot more than 10.0 kg";

	// this custom exception is thrown when a product description is invalid
	public static final String INVALID_PRODUCT_DESCRIPTION = "Product description cannot be null or empty and its length less than 30";

	// this custom exception is thrown when a product created date is invalid
	public static final String INVALID_PRODUCT_CREATED_DATE = "Product date cannot be null or empty and Invalid";

}
