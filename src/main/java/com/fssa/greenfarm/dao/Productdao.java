package com.fssa.greenfarm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.fssa.greenfarm.model.Product;

public class Productdao {

	// adding product

	public static void addProduct(Product product) throws SQLException {
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
   System.out.println(pst);
	            pst.executeUpdate();
	        } catch (SQLException e) {
	            // Handle the exception appropriately
	            e.printStackTrace(); // For example, you can log the error
	            // You can also re-throw the same exception to propagate it to the calling code
	            throw e;
	        }
	    }
	}

//
//	// main method
//	public static void main(String[] args) throws SQLException {
//
//		Product pr = new Product("Brinjal", 4, "www.Brinjal.png", 50, 2, 50, "It is good in vitamins and proteins",
//				"vegetables", null);
//		// addProduct(pr);
//		updateProduct(pr);
//		searchingPrice(30, 60);
//
//	}

	// deleting product
	public static void deleteProduct(int productId,String productName) throws SQLException {
		if(productId <= 0) {
			throw new SQLException("product id cannot be zero or negative");
		}

		Connection connection = ProductConnection.getConnection();

		// Create delete statement

		String query = "DELETE FROM Product WHERE ProductName = ? AND ProductId = ?";

		// Execute delete statement
		try {

			PreparedStatement pst = connection.prepareStatement(query);
			
			pst.setString(1, productName);
			pst.setInt(2,productId);
		
			int rowsDeleted = pst.executeUpdate();
			if (rowsDeleted > 0) {
				System.out.println("Product with ID " + productId + " deleted successfully.");

			} else {

				System.out.println("Product with ID " + productId + " not found.");

			}
		} catch (SQLException e) {

			throw new SQLException("Error occurred while deleting the product.");

		} finally {
			// Close connection
			ProductConnection.close(connection, null, null);
		}
	}

	// reading product
	public static Product readProduct(int productId) throws SQLException {

		Connection connection = ProductConnection.getConnection();

		// Create SELECT statement
		String query = "SELECT * FROM Product WHERE ProductId = ?";

		try {

			PreparedStatement pst = connection.prepareStatement(query);

			pst.setInt(2, productId);

			ResultSet resultSet = pst.executeQuery();

			if (resultSet.next()) {
				// Extracting the data from the result set
				System.out.println(resultSet.getInt("ProductId"));

			} else {
				System.out.println("Product not found.");
				return null;
			}
		} catch (SQLException e) {

			throw new SQLException("Error occurred.");

		} finally {
			// Close connection
			ProductConnection.close(connection, null, null);
		}
		return null;
	}

//	int productId, String newProductName, double newPrice,String productImageURL,double productQuantity,
//	String productDescription ,String productCategory
//	updating product
	public static void updateProduct(Product product) throws SQLException {

		Connection connection = ProductConnection.getConnection();

		// Create update statement
		String query = "UPDATE Product SET ProductName = ?, ProductPrice = ? ,ProductImageUrl=?,ProductQuantity=?,ProductPercentage=?,ProductDescription=?,ProductCategory=? WHERE ProductId = ?";

		try {
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
			System.out.println(rowsUpdated);

			if (rowsUpdated > 0) {

				System.out.println("Product with ID " + product.getId() + " updated successfully.");


			} else {

				System.out.println("Product with ID " + product.getId() + " not found.");


			}
		} catch (SQLException e) {

			throw new SQLException("Error occurred while updating the product.");

		} finally {
			// Close connection
			ProductConnection.close(connection, null, null);
		}
	}

	// method for searching the product and listing it according to its price range

	public static Product searchingPrice(int fromrange, int torange) throws SQLException {

		// creating connection
		Connection connection = ProductConnection.getConnection();

		// creating select statement
		String query = "select * from Product where ProductPrice Between ? AND ? ";

		try {
			PreparedStatement pst = connection.prepareStatement(query);

			pst.setInt(1, fromrange);
			pst.setInt(2, torange);

			ResultSet resultset = pst.executeQuery();

			if (resultset.next()) {
				System.out.println(resultset.getString("ProductName"));

			} else {
				System.out.println("Product not found.");
				return null;
			}

		} catch (SQLException e) {

			System.out.println(e.getMessage());
			throw new SQLException("Error occurred.");

		} finally {
			// Close connection
			ProductConnection.close(connection, null, null);
		}
		return null;

	}

}

