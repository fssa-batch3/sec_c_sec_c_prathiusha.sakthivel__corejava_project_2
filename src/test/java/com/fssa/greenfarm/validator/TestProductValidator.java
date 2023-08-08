package com.fssa.greenfarm.validator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.greenfarm.exception.ProductInvalidException;
import com.fssa.greenfarm.model.Product;
import com.fssa.greenfarm.model.ProductValidatorErrors;

public class TestProductValidator {

	// Test case for the validate method when the product is not null
	@Test
	public void testValidateNotNull() {

		try {

			Product product = new Product("Tomato", 001, "www.tomato.png", 100, 1.5, 25, "Toamato", "Veges", null);
			boolean isValid = ProductValidator.validate(product);

		} catch (ProductInvalidException ex) {

			// this will fail when an exception is thrown
			Assertions.assertEquals(ProductValidatorErrors.INVALID_PRODUCT_ImageURL,ex.getMessage());

		}

	}

	// Test case for the validate method when the product is null
	@Test
	public void testValidateNull() {

		Product invalidProduct = null;

		try {

			ProductValidator.validate(invalidProduct);
			// it will fail when there is no exception is thrown
			fail("Expected IllegalArgumentException, but no exception was thrown"); 

		} catch (ProductInvalidException ex) {

			assertEquals(ProductValidatorErrors.INVALID_PRODUCT_NULL, ex.getMessage(), "Invalid exception message");

		}
	}

	// 1---test case for product name
	@Test
	public void testValidProductName() throws ProductInvalidException {
		String productName = "Tomato"; // Valid product name
		Product product1 = new Product();
		product1.setName(productName);
		
		Assertions.assertTrue(ProductValidator.validateProductName(product1.getName()));
//		try {
//
//			String productName = "Tomato"; // Valid product name
//			Product product1 = new Product();
//			product1.setName(productName);
//			ProductValidator.validateProductName(product1.getName());
//
//		} catch (ProductInvalidException ex) {
//
//			// If an exception is thrown, the test should fail
//			Assertions.assertEquals(ex.getMessage(), ProductValidatorErrors.INVALID_PRODUCT_NAME);
//
//		}
		
	}

	@Test
	public void testNullProductName() {
		try {

			String productName = null; // Null product
			Product product1 = new Product(); 
			product1.setName(productName);
			ProductValidator.validateProductName(product1.getName());

		} catch (ProductInvalidException ex) {

			// If an exception is thrown, the test should fail
			Assertions.assertEquals(ProductValidatorErrors.INVALID_PRODUCT_NAME,ex.getMessage());

		}
	}

	@Test
	public void testEmptyProductName() {
		try {

			String productName = ""; // Empty product
			Product product1 = new Product();
			product1.setName(productName);
			ProductValidator.validateProductName(product1.getName());

		} catch (ProductInvalidException ex) {

			Assertions.assertEquals(ProductValidatorErrors.INVALID_PRODUCT_NAME,ex.getMessage());

		}
	}

	@Test
	public void testProductNameWithSpaces() throws ProductInvalidException {
//		try {

			String productName = "Lady's Finger"; // Product name with spaces
			Product product1 = new Product();
			product1.setName(productName);
			Assertions.assertTrue(ProductValidator.validateProductName(product1.getName()));
			

//		} catch (ProductInvalidException ex) {
//
//			Assertions.assertEquals(ex.getMessage(), ProductValidatorErrors.INVALID_PRODUCT_NAME);
//
//		}

	}

	@Test
	public void testProductNameTooShort() {
		try {

			String productName = "f"; // Product name with length less than 2
			Product product1 = new Product();
			product1.setName(productName);
			ProductValidator.validateProductName(product1.getName());

		} catch (ProductInvalidException ex) {

			Assertions.assertEquals(ProductValidatorErrors.INVALID_PRODUCT_NAME,ex.getMessage());

		}

	}

	// 2---test case for product id

	@Test
	public void testValidProductId() throws ProductInvalidException {
		
		int productId = 55; // valid product id
		Product productid = new Product();
		productid.setId(productId);
		Assertions.assertTrue(ProductValidator.validateProductId(productid.getId()));
//		try {
//
//			int productId = 55; // valid product id
//			Product productid = new Product();
//			productid.setId(productId);
//			ProductValidator.validateProductId(productid.getId());
//
//		} catch (ProductInvalidException ex) {
//
//			Assertions.assertEquals(ex.getMessage(), ProductValidatorErrors.INVALID_PRODUCT_ID);
//
//		}

	}

	@Test
	public void testInValidProductId() {
		try {

			int productId = -5; // Invalid product id
			Product productid = new Product();
			productid.setId(productId);
			ProductValidator.validateProductId(productid.getId());

		} catch (ProductInvalidException ex) {

			Assertions.assertEquals(ProductValidatorErrors.INVALID_PRODUCT_ID,ex.getMessage());

		}

	}
	// 3---test case for product Image URL

	@Test
	public void testValidProductImageURL() throws ProductInvalidException {
//		try {

			String productImageURL = "https://iili.io/HZd9gUX.jpg"; // valid product ImageURL
			Product producturl = new Product();
			producturl.setImageURL(productImageURL);
			Assertions.assertTrue(ProductValidator.validateProductImageURL(producturl.getImageURL()));
			

//		} catch (ProductInvalidException ex) {
//
//			Assertions.assertEquals(ex.getMessage(), ProductValidatorErrors.INVALID_PRODUCT_ImageURL);
//
//		}

	}

	@Test
	public void testInValidNullProductImageURL() {
		try {

			String productImageURL = null; // null product ImageURL
			Product producturl = new Product();
			producturl.setImageURL(productImageURL);
			ProductValidator.validateProductImageURL(producturl.getImageURL());

		} catch (ProductInvalidException ex) {

			Assertions.assertEquals(ProductValidatorErrors.INVALID_PRODUCT_ImageURL,ex.getMessage());

		}

	}

	@Test
	public void testInValidEmptyProductImageURL() {
		try {

			String productImageURL = "";// empty product ImageURL
			Product producturl = new Product();
			producturl.setImageURL(productImageURL);
			ProductValidator.validateProductImageURL(producturl.getImageURL());

		} catch (ProductInvalidException ex) {

			Assertions.assertEquals(ProductValidatorErrors.INVALID_PRODUCT_ImageURL,ex.getMessage());

		}

	}

	@Test
	// 4---test case for product price
	public void testValidProductPrice() throws ProductInvalidException {
//		try {

			int productPrice = 500; // valid product price
			Product productcost = new Product();
			productcost.setPrice(productPrice);
			Assertions.assertTrue(ProductValidator.validateProductPrice(productcost.getPrice()));
			

//		} catch (ProductInvalidException ex) {
//
//			Assertions.assertEquals(ex.getMessage(), ProductValidatorErrors.INVALID_PRODUCT_PRICE);
//
//		}

	}

	@Test
	public void testInValidProductPrice() {
		try {

			int productPrice = 5; // Invalid product price
			Product productcost = new Product();
			productcost.setPrice(productPrice);
			ProductValidator.validateProductPrice(productcost.getPrice());

		} catch (ProductInvalidException ex) {

			Assertions.assertEquals(ProductValidatorErrors.INVALID_PRODUCT_PRICE,ex.getMessage());

		}

	}

	// 5---test case for product quantity

	@Test
	public void testValidProductQuantity() throws ProductInvalidException {
//		try {

			// Valid product quantity
			double productvalidQuantity = 5.0;
			Product quantity = new Product();
			quantity.setQuantity(productvalidQuantity);
			Assertions.assertTrue(ProductValidator.validateProductQuantity(quantity.getQuantity()));
			

//		} catch (ProductInvalidException ex) {
//
//			Assertions.assertEquals(ex.getMessage(), ProductValidatorErrors.INVALID_PRODUCT_QUANTITY);
//
//		}
	}

	@Test
	public void testInvalidZeroProductQuantity() {
		try {

			// Invalid product quantity zero as a value
			double zeroValueAsQuantity = 0.0;
			Product quantity = new Product();
			quantity.setQuantity(zeroValueAsQuantity);
			ProductValidator.validateProductQuantity(quantity.getQuantity());

		} catch (ProductInvalidException ex) {

			Assertions.assertEquals(ProductValidatorErrors.INVALID_PRODUCT_QUANTITY,ex.getMessage());

		}
	}

	@Test
	public void testInvalidNegativeProductQuantity() {
		try {

			// Invalid product quantity negative value as a value
			double negativeValueAsQuantity = -2.5;
			Product quantity = new Product();
			quantity.setQuantity(negativeValueAsQuantity);
			ProductValidator.validateProductQuantity(quantity.getQuantity());

		} catch (ProductInvalidException ex) {

			Assertions.assertEquals(ProductValidatorErrors.INVALID_PRODUCT_QUANTITY,ex.getMessage());

		}
	}

	@Test
	public void testInvalidGreaterProductQuantity() {
		try {

			// Invalid product quantity value greater than 10
			double greaterQuantity = 15.0;
			Product quantity = new Product();
			quantity.setQuantity(greaterQuantity);
			ProductValidator.validateProductQuantity(quantity.getQuantity());

		} catch (ProductInvalidException ex) {

			Assertions.assertEquals(ProductValidatorErrors.INVALID_PRODUCT_QUANTITY,ex.getMessage());

		}
	}

	// 6---test case for product percentage

	@Test
	public void testValidProductPercentage() throws ProductInvalidException {
//		try {

			int productpercent = 50; // valid product id
			Product productoffer = new Product();
			productoffer.setPercentage(productpercent);
			Assertions.assertTrue(ProductValidator.validateProductPercentage(productoffer.getPercentage()));
			

//		} catch (ProductInvalidException ex) {
//
//			Assertions.assertEquals(ex.getMessage(), ProductValidatorErrors.INVALID_PRODUCT_OFFER);
//
//		}

	}

	@Test
	public void testInValidProductPercentage() {
		try {
			int productpercent = 0; // valid product id
			Product productoffer = new Product();
			productoffer.setPercentage(productpercent);
			ProductValidator.validateProductPercentage(productoffer.getPercentage());

		} catch (ProductInvalidException ex) {

			Assertions.assertEquals(ProductValidatorErrors.INVALID_PRODUCT_OFFER,ex.getMessage());

		}

	}

	// 7---test case for product description

	@Test
	public void testValidProductDescription() throws ProductInvalidException {
//		try {

			String validDescription = "No single fruit or vegetable provides all of the nutrients you need to be healthy. Eat plenty every day.";
			Product description = new Product();
			description.setDescription(validDescription);
			Assertions.assertTrue(ProductValidator.validateProductDescription(description.getDescription()));

//		} catch (ProductInvalidException ex) {
//
//			Assertions.assertEquals(ex.getMessage(), ProductValidatorErrors.INVALID_PRODUCT_DESCRIPTION);
//
//		}
	}

	@Test
	public void testNullProductDescription() {
		try {

			String nullProductDescription = null;
			Product description = new Product();
			description.setDescription(nullProductDescription);
			ProductValidator.validateProductDescription(description.getDescription());

		} catch (ProductInvalidException ex) {

			Assertions.assertEquals(ProductValidatorErrors.INVALID_PRODUCT_DESCRIPTION,ex.getMessage());

		}
	}

	@Test
	public void testEmptyProductDescription() {
		try {

			String emptyProductDescription = "";
			Product description = new Product();
			description.setDescription(emptyProductDescription);
			ProductValidator.validateProductDescription(description.getDescription());

		} catch (ProductInvalidException ex) {

			Assertions.assertEquals(ProductValidatorErrors.INVALID_PRODUCT_DESCRIPTION,ex.getMessage());

		}
	}

	@Test
	public void testProductLengthDescription() {
		try {

			String lengthProductDescription = "ssss";
			Product description = new Product();
			description.setDescription(lengthProductDescription);
			ProductValidator.validateProductDescription(description.getDescription());

		} catch (ProductInvalidException ex) {

			Assertions.assertEquals(ProductValidatorErrors.INVALID_PRODUCT_DESCRIPTION,ex.getMessage());

		}
	}

	@Test
	public void testInvalidProductDescription() {
		try {

			String invalidDescription = "nkjkjkjjlkjlm";
			Product description = new Product();
			description.setDescription(invalidDescription);
			ProductValidator.validateProductDescription(description.getDescription());

		} catch (ProductInvalidException ex) {

			Assertions.assertEquals(ProductValidatorErrors.INVALID_PRODUCT_DESCRIPTION,ex.getMessage());

		}
	}

	// 9---test case for product created date
	@Test
	public void testValidProductCreatedDate() throws ProductInvalidException {

		LocalDate createdDate = LocalDate.of(2020, 1, 1);

		boolean isValid = ProductValidator.validateProductCreatedDate(createdDate);

		Assertions.assertTrue(isValid);

	}	

@Test
	public void testNullProductCreatedDate() {
		try {

			LocalDate createdDate = null;
			Product datecreated = new Product();
			datecreated.setCreateddate(createdDate);
			ProductValidator.validateProductCreatedDate(datecreated.getCreateddate());

		} catch (ProductInvalidException ex) {

			Assertions.assertEquals(ProductValidatorErrors.INVALID_PRODUCT_CREATED_DATE,ex.getMessage());

		}
	}

	@Test
	public void testProductCreatedDateFuture() {
		try {

			LocalDate createdDate = LocalDate.now().plusDays(1);
			Product datecreated = new Product();
			datecreated.setCreateddate(createdDate);
			ProductValidator.validateProductCreatedDate(datecreated.getCreateddate());

		} catch (ProductInvalidException ex) {

			 Assertions.assertEquals(ProductValidatorErrors.INVALID_PRODUCT_CREATED_DATE, ex.getMessage());		}
	}

}


