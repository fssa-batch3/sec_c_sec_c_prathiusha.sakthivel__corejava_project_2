package com.fssa.greenfarm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.fssa.greenfarm.exception.DAOException;
import com.fssa.greenfarm.logger.Logger;
import com.fssa.greenfarm.model.Product;

public class Productdao {

	// adding product

	public static void addProduct(Product product) throws DAOException, SQLException {
	    try (Connection connection = ProductConnection.getConnection()) {
	        // Create insert statement
	        String query = "insert into Product(ProductName, ProductId, ProductImageUrl, ProductPrice, ProductQuantity, ProductPercentage, ProductDescription, ProductCategory, ProductCreatedDate) values (?,?,?,?,?,?,?,?,?)";
 
	        // Execute insert statement
	        try (PreparedStatement pst = connection.prepareStatement(query)) {
	            pst.setString(1, product.getName());
	            pst.setInt(2, product.getId());
	            pst.setString(3, product.getImageURL());
	            pst.setDouble(4, product.getPrice());
	            pst.setDouble(5, product.getQuantity());
	            pst.setInt(6, product.getPercentage());
	            pst.setString(7, product.getDescription());
	            pst.setString(8, product.getCategory());
	            pst.setDate(9, java.sql.Date.valueOf(product.getCreateddate()));
	            Logger.info(pst);
	            pst.executeUpdate();
	        } catch (SQLException e) {
	            // Handle the exception appropriately
	            e.getMessage(); // For example, you can log the error
	            // You can also re-throw the same exception to propagate it to the calling code
	            throw e;
	        }
	    }
	}
  

	// deleting product
	public static void deleteProduct(int productId,String productName) throws SQLException, DAOException {
		if(productId <= 0) {
			throw new SQLException("product id cannot be zero or negative");
		}
		String query = "DELETE FROM Product WHERE ProductName = ? AND ProductId = ?";
		
		// Execute delete statement
		try(Connection connection = ProductConnection.getConnection()) {

			// Create delete statement

			

			try(PreparedStatement pst = connection.prepareStatement(query)){
			
			pst.setString(1, productName);
			pst.setInt(2,productId);
		
			int rowsDeleted = pst.executeUpdate();
			
			if (rowsDeleted > 0) {
				Logger.info("Product with ID " + productId + " deleted successfully.");

			} else {

				Logger.info("Product with ID " + productId + " not found.");

			}
			}
		} catch (SQLException e) {

			throw new SQLException("Error occurred while deleting the product.");

		} 
	}

	// reading product
	public static Product readProduct(int productId) throws SQLException, DAOException {

		try(Connection connection = ProductConnection.getConnection()) {
			
			// Create SELECT statement
			String query = "SELECT * FROM Product WHERE ProductId = ?";

			PreparedStatement pst = connection.prepareStatement(query);

			pst.setInt(1, productId);

			ResultSet resultSet = pst.executeQuery();

			if (resultSet.next()) {
				// Extracting the data from the result set
				Logger.info(resultSet.getInt("ProductId"));

			} else {
				Logger.info("Product not found.");
				return null;
			}
		} catch (SQLException e) {

			throw new SQLException("Error occurred." + e.getMessage());

		} 
		return null;
	}

//	int productId, String newProductName, double newPrice,String productImageURL,double productQuantity,
//	String productDescription ,String productCategory
//	updating product
	public static void updateProduct(Product product) throws SQLException, DAOException {

		try(Connection connection = ProductConnection.getConnection()) {
			// Create update statement
			String query = "UPDATE Product SET ProductName = ?, ProductPrice = ? ,ProductImageUrl=?,ProductQuantity=?,ProductPercentage=?,ProductDescription=?,ProductCategory=? WHERE ProductId = ?";

			PreparedStatement pst = connection.prepareStatement(query);
			System.out.println(pst);
			pst.setString(1, product.getName()); 
			pst.setDouble(2, product.getPrice());
			pst.setString(3, product.getImageURL());
			pst.setDouble(4, product.getQuantity());
			pst.setInt(5, product.getPercentage());
			pst.setString(6, product.getDescription());
			pst.setString(7, product.getCategory());
			pst.setInt(8, product.getId());

			int rowsUpdated = pst.executeUpdate();
			Logger.info(rowsUpdated);

			if (rowsUpdated > 0) {

				Logger.info("Product with ID " + product.getId() + " updated successfully.");


			} else {

				Logger.info("Product with ID " + product.getId() + " not found.");


			}
		} catch (SQLException e) {

			throw new SQLException("Error occurred while updating the product.");

		} 
	}

	// method for searching the product and listing it according to its price range

	public static Product searchingPrice(int fromrange, int torange) throws SQLException, DAOException {
	
		try (Connection connection = ProductConnection.getConnection()){
			// creating select statement
			String query = "select * from Product where ProductPrice Between ? AND ? ";

			PreparedStatement pst = connection.prepareStatement(query);

			pst.setInt(1, fromrange);
			pst.setInt(2, torange);

			ResultSet resultset = pst.executeQuery();

			if (resultset.next()) {
				Logger.info(resultset.getString("ProductName")); 

			} else {
				Logger.info("Product not found.");
				return null;
			}

		} catch (SQLException e) {

			Logger.info(e.getMessage());
			throw new SQLException("Error occurred.");

		} 
		return null;

	}

}

