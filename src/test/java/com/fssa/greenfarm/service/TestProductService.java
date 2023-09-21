package com.fssa.greenfarm.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.greenfarm.exception.DAOException;
import com.fssa.greenfarm.exception.ProductInvalidException;
import com.fssa.greenfarm.logger.Logger;
import com.fssa.greenfarm.model.Product;

public class TestProductService {

	@Test
	void testAddProduct() {
		// Create a sample product for testing
		Product product = new Product("FreshorganicRadish", 13,"https://iili.io/J9lwBee.jpg", 50, 2, 50,
				"It is good in vitamins and proteins and carbohydrates", "vegetable", LocalDate.of(2023, 07, 10));
		ProductService productservice = new ProductService();

		assertDoesNotThrow(() -> productservice.addProduct(product));

	}
 
 
	@Test
	void testInvalidAddProduct() {
		// Create a sample product for testing
		Product product = new Product();
		ProductService productservice = new ProductService();

		assertThrows(ProductInvalidException.class, () -> productservice.addProduct(product)); // The product should be
																								// added successfully
	}

	@Test
	void testUpdateProduct() throws SQLException, ProductInvalidException, DAOException {
		
		Product product = new Product();
		
		product.setId(15);
		product.setName("FreshOrganicCarrot");
		product.setImageURL("https://iili.io/Hy0ZSZF.jpg");
		product.setPrice(50);
		product.setQuantity(4);
		product.setPercentage(50);
		product.setDescription("It is good in vitamins and proteins");
		product.setCategory("vegetable");
		product.setCreateddate(LocalDate.of(2023, 07, 10));
		
		Assertions.assertTrue(ProductService.updateProduct(product));

	}

	public ProductService getProductService() {

		ProductService productService = new ProductService();
		return productService;
	   
	}

	@Test
	void testInvalidUpdateProduct() {
		Product product = new Product();
		ProductService productservice = new ProductService();

		assertThrows(ProductInvalidException.class, () -> productservice.addProduct(product)); // The product should be
																								// added successfully
	}

	@Test
	void testDeleteProduct() {
		try {
			Assertions.assertTrue(ProductService.deleteProduct(15, "FreshOrganicCarrot"));
		} catch (Exception e) {
			Assertions.assertEquals("Error occurred while deleting the product.", e.getMessage());
		}
	}

	@Test
	void testInvalidDeleteProduct() {
		try { 
			Assertions.assertTrue(ProductService.deleteProduct(3, null));
		} catch (Exception e) {
			Assertions.assertEquals("Error occurred while deleting the product.", e.getMessage());
		}
	}

	@Test
	void testSearchingProductNameValidInput() throws SQLException, ProductInvalidException, DAOException {
		
		ProductService productservice = new ProductService();
		Product product= new Product();
		product.setName("c");
		List<Product> productList = productservice.searchProductByName(product.getName());
		for (Product ex : productList) {
			Logger.info(ex);
		}
	       Assertions.assertFalse(productList.isEmpty());
	}
	
    @Test
    void testSearchingPriceValidInput() throws SQLException, ProductInvalidException, DAOException {
      
       int fromRange = 49;
       int toRange = 51;
       ProductService productservice = new ProductService();
       Product product = new Product();
       product.setPrice(fromRange);
       product.setPrice(toRange);
       List<Product> productlist = productservice.searchingPrice(fromRange, toRange);
       for (Product ex : productlist) {
			Logger.info(ex);
		}
       Assertions.assertFalse(productlist.isEmpty());
	}
	

	@Test
	void testReadProduct() {
		ProductService productservices = new ProductService();
		assertDoesNotThrow(() -> productservices.readProduct(29));

	}

	@Test
	void testReadNonexistentProduct() {
		ProductService productservices = new ProductService();
		assertThrows(ProductInvalidException.class, () -> productservices.readProduct(1000));
	}

	@Test
	void testgetAllProductDetails() throws DAOException, SQLException, ProductInvalidException {
		ProductService productService = getProductService();
		List<Product> productList = productService.readAllProduct();
		for (Product e : productList) {
			Logger.info(e);
		}
		Assertions.assertFalse(productList.isEmpty());
	} 

	@Test
	void testGetProductById() {
		ProductService productservices = new ProductService();
		
		assertDoesNotThrow(() -> ProductService.getProductById(1));
	}
	
}
