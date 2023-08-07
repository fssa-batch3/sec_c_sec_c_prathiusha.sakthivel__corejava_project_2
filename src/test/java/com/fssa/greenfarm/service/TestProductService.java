package com.fssa.greenfarm.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.sql.SQLException;
import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.greenfarm.exception.ProductInvalidException;
import com.fssa.greenfarm.model.Product;

public class TestProductService {

	@Test
	public void testAddProduct() {
		// Create a sample product for testing
		Product product = new Product("Beetroot", 5, "https://iili.io/.jpg", 500, 2, 50, "It is good in vitamins and proteins", "vegetable", LocalDate.of(2023, 07, 10));
		ProductService productservice = new ProductService();

		assertDoesNotThrow(() -> productservice.addProduct(product));
		
		
		// The product should be added successfully
		
	}
	

	@Test
	public void testInvalidAddProduct() {
		// Create a sample product for testing
		Product product = new Product();
		ProductService productservice = new ProductService();
		
		assertThrows(ProductInvalidException.class, () ->  productservice.addProduct(product)); // The product should be added successfully

	}

	@Test
	public void testUpdateProduct() throws SQLException, ProductInvalidException {
		Product product = new Product();	
		ProductService productservice = new ProductService();
		
		product.setName("Beetroot");
		product.setId(5);
		product.setImageURL("https://iili.io/.png");
		product.setPrice(70);
		product.setQuantity(2);
		product.setPercentage(50);
		product.setDescription("It is good in vitamins and proteins");
		product.setCategory("vegetable");
		product.setCreateddate(LocalDate.of(2023, 07, 10));
		Assertions.assertTrue(ProductService.updateProduct(product));
		
	}

	@Test
	public void testInvalidUpdateProduct() {
		Product product = new Product();
		ProductService productservice = new ProductService();
		
		assertThrows(ProductInvalidException.class, () ->  productservice.addProduct(product)); // The product should be added successfully

	} 

	@Test
	public void testDeleteProduct() {
		try {
			Assertions.assertTrue(ProductService.deleteProduct(3,"Tomato"));
		} catch (Exception e) {
			Assertions.assertEquals("Error occurred while deleting the product.", e.getMessage());
		}
	}

	@Test
	public void testInvalidDeleteProduct() {
		try {
			Assertions.assertTrue(ProductService.deleteProduct(3, null));
		} catch (Exception e) {
			Assertions.assertEquals("Error occurred while deleting the product.", e.getMessage());
		}
	}
	

    @Test
    public void testSearchingPriceValidInput() {
       
        int fromRange = 40;
        int toRange = 100;
        ProductService productservice = new ProductService();
        
        assertDoesNotThrow(() -> productservice.searchingPrice(fromRange, toRange));
	}
	
}



