package com.fssa.greenfarm.service;

import java.sql.SQLException;

import com.fssa.greenfarm.dao.Productdao;
import com.fssa.greenfarm.exception.ProductInvalidException;
import com.fssa.greenfarm.model.Product;
import com.fssa.greenfarm.validator.ProductValidator;

public class ProductService {

	// adding product
	public boolean addProduct(Product product) throws  SQLException, ProductInvalidException {

		if (ProductValidator.validate(product)) {

			Productdao.addProduct(product);
			return true;
		}
		return false;   
	}
	
	// updating product
	public static  boolean updateProduct(Product product) throws SQLException, ProductInvalidException {

		if (ProductValidator.validate(product)) { 

			Productdao.updateProduct(product); 
			return true;
		} 
		return false; 
	}

	// reading product
	public  Product readProduct(int id) throws SQLException, ProductInvalidException {

		if (ProductValidator.validateProductId(id)) {
			return Productdao.readProduct(id);
		}
		return null;
	}

	// deleting product
	public static  boolean deleteProduct(int id) throws SQLException, ProductInvalidException {

		if (ProductValidator.validateProductId(id)) {
			 Productdao.deleteProduct(id);
			 return true;
		}
		return false;
	}

	// searching product according to its price range
	public  Product searchingPrice(int fromrange, int torange) throws SQLException, ProductInvalidException {

		if (ProductValidator.validateProductPrice(torange)) {
			return Productdao.searchingPrice(fromrange, torange);
		}
		return null;
	}


	
}


