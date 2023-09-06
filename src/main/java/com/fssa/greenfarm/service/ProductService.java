package com.fssa.greenfarm.service;

import java.sql.SQLException;
import java.util.List;

import com.fssa.greenfarm.DAO.ProductDAO;
import com.fssa.greenfarm.exception.DAOException;
import com.fssa.greenfarm.exception.ProductInvalidException;
import com.fssa.greenfarm.logger.Logger;
import com.fssa.greenfarm.model.Product;
import com.fssa.greenfarm.validator.ProductValidator;

public class ProductService {

	// adding product
	public boolean addProduct(Product product)
			throws SQLException, DAOException, ProductInvalidException {

		if (ProductValidator.validate(product)) {

			ProductDAO.addProduct(product);
			return true;
		}
		return false;
	}

	// updating product
	public static boolean updateProduct(Product product)
			throws SQLException, ProductInvalidException, DAOException {

		if (ProductValidator.validate(product)) {
 
			ProductDAO.updateProduct(product);
		}
		return true;
	}

	// reading product
	public static Product readProduct(int id)
			throws SQLException, ProductInvalidException, DAOException {

		if (ProductValidator.validateProductId(id)) {
			return ProductDAO.readProduct(id);
		}
		return null;
	}

	// deleting product
	public static boolean deleteProduct(int id, String name) 
			throws SQLException, ProductInvalidException, DAOException {

		if (ProductValidator.validateProductId(id)) {
			ProductDAO.deleteProduct(id, name);
			return true;
		}
		return false;
	}

	// listing product by its name
	public List<Product> searchProductByName(String product) 
			throws SQLException, ProductInvalidException, DAOException {

		return ProductDAO.searchProductByName(product);

	}

	// reading all product
	public List<Product> readAllProduct() throws SQLException, ProductInvalidException, DAOException {
		return ProductDAO.readAllProduct();

	}
	
	// searching product according to its price range
		public  List<Product> searchingPrice(double fromrange, double torange) 
				throws SQLException, ProductInvalidException, DAOException {

			return ProductDAO.searchingPrice(fromrange, torange);
		}


}
