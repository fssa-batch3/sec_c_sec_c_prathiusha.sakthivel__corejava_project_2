package com.fssa.greenfarm.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fssa.greenfarm.exception.DAOException;
import com.fssa.greenfarm.logger.Logger;
import com.fssa.greenfarm.model.Product;

public class ProductDAO {

	// Private constructor to prevent instantiation
	public ProductDAO() {
		// Private constructor to prevent instantiation
	}
	// adding product//

	public static Product addProduct(Product product) throws DAOException, SQLException {
		// Create insert statement

		Product addProduct = new Product();

		try (Connection connection = ProductConnection.getConnection()) {

			String query = "insert into Product(product_name,product_id, product_imageUrl, product_price, product_quantity, product_percentage, product_description, product_category, product_createdDate) values (?,?,?,?,?,?,?,?,?)";

			// Execute insert statement
			try (PreparedStatement pst = connection.prepareStatement(query)) {
				pst.setString(1, product.getName());
				pst.setInt(2, product.getId());// need not
				pst.setString(3, product.getImageURL());
				pst.setDouble(4, product.getPrice());
				pst.setDouble(5, product.getQuantity());
				pst.setInt(6, product.getPercentage());
				pst.setString(7, product.getDescription());
				pst.setString(8, product.getCategory());
				pst.setDate(9, java.sql.Date.valueOf(product.getCreateddate()));

				pst.executeUpdate();
			}
		} catch (SQLException e) {
			// Handle the exception appropriately
			// You can also re-throw the same exception to propagate it to the calling code
			throw new DAOException("Error while adding product: " + e.getMessage());
		}
		return addProduct;
	}

	// deleting product
	public static Product deleteProduct(int productId, String productName) throws SQLException, DAOException {

		// Execute delete statement
		try (Connection connection = ProductConnection.getConnection()) {

			String query = "DELETE FROM Product WHERE product_name = ? AND product_id = ?";

			try (PreparedStatement pst = connection.prepareStatement(query)) {

				pst.setString(1, productName);
				pst.setInt(2, productId);

				pst.executeUpdate();

			}
		} catch (SQLException e) {
			throw new SQLException("Error occurred while deleting the product: " + e.getMessage());
		}

		return null;

	}

	// reading product
	public static Product readProduct(int productId) throws SQLException, DAOException {

		Product readproduct = new Product();
		// Create SELECT statement
		String query = "SELECT * FROM Product WHERE product_id = ?";

		try (Connection connection = ProductConnection.getConnection()) {

			try (PreparedStatement pst = connection.prepareStatement(query)) {

				pst.setInt(1, productId);

				try (ResultSet rs = pst.executeQuery()) {

					Logger.info(rs.getMetaData().getColumnName(1));

					if (rs.next()) {

						readproduct.setName(rs.getString("product_name"));
						readproduct.setId(rs.getInt("product_id"));
						readproduct.setImageURL(rs.getString("product_imageUrl"));
						readproduct.setPrice(rs.getDouble("product_price"));
						readproduct.setQuantity(rs.getDouble("product_quantity"));
						readproduct.setPercentage(rs.getInt("product_percentage"));
						readproduct.setDescription(rs.getString("product_description"));
						readproduct.setCategory(rs.getString("product_category"));
						readproduct.setCreateddate(rs.getDate("product_createdDate").toLocalDate());
					}
				}

			}
		} catch (SQLException e) {
			throw new SQLException("Error while reading product: " + e.getMessage());
		}

		return readproduct;
	}

//	int productId, String newProductName, double newPrice,String productImageURL,double productQuantity,
//	String productDescription ,String productCategory
//	updating product
	public static boolean updateProduct(Product product) throws SQLException, DAOException {

//		Product updateProduct = new Product();
		// Create update statement
		String query = "UPDATE Product SET product_name = ?, product_price = ? ,product_imageUrl=?,product_quantity=?,product_percentage=?,product_description=?,product_category=? WHERE product_id = ?";

		try (Connection connection = ProductConnection.getConnection()) {

			try (PreparedStatement pst = connection.prepareStatement(query)) {

				pst.setString(1, product.getName());
				pst.setDouble(2, product.getPrice());
				pst.setString(3, product.getImageURL());
				pst.setDouble(4, product.getQuantity());
				pst.setInt(5, product.getPercentage());
				pst.setString(6, product.getDescription());
				pst.setString(7, product.getCategory());
				pst.setInt(8, product.getId());

				int rowAffected = pst.executeUpdate();

				return rowAffected > 0;

			}
		} catch (SQLException e) {
			throw new SQLException("Error while updating product: " + e.getMessage());
		}

	}

	// method for searching the product and listing it according to its price range

	public static List<Product> searchProductByName(String product) throws SQLException, DAOException {

		List<Product> searchproduct = new ArrayList<>();

		try (Connection connection = ProductConnection.getConnection()) {

			// creating select statement
			String query = "select * from Product where product_name LIKE ?";

			try (PreparedStatement pst = connection.prepareStatement(query)) {

				pst.setString(1, "%" + product + "%");

				try (ResultSet resultset = pst.executeQuery()) {

					while (resultset.next()) {
						Product searchproductname = new Product();
						searchproductname.setName(resultset.getString("product_name"));
						searchproductname.setId(resultset.getInt("product_id"));
						searchproductname.setImageURL(resultset.getString("product_imageUrl"));
						searchproductname.setPrice(resultset.getDouble("product_price"));
						searchproductname.setQuantity(resultset.getDouble("product_quantity"));
						searchproductname.setPercentage(resultset.getInt("product_percentage"));
						searchproductname.setDescription(resultset.getString("product_description"));
						searchproductname.setCategory(resultset.getString("product_category"));
						searchproductname.setCreateddate(resultset.getDate("product_createdDate").toLocalDate());
						searchproduct.add(searchproductname);

					}

				}
			}

		} catch (SQLException e) {
			throw new SQLException("Error while searching product: " + e.getMessage());
		}
		return searchproduct;
	}

	// reading all product

	public static List<Product> readAllProduct() throws SQLException, DAOException {// naming convention

		List<Product> productList = new ArrayList<>();

		try (Connection con = ProductConnection.getConnection()) {
			// creating query
			String query = "SELECT * FROM Product";

			try (PreparedStatement pst = con.prepareStatement(query)) {

				try (ResultSet rs = pst.executeQuery(query)) {

					while (rs.next()) {
						Product readallproduct = new Product();
						readallproduct.setName(rs.getString("product_name"));
						readallproduct.setId(rs.getInt("product_id"));
						readallproduct.setImageURL(rs.getString("product_imageUrl"));
						readallproduct.setPrice(rs.getDouble("product_price"));
						readallproduct.setQuantity(rs.getDouble("product_quantity"));
						readallproduct.setPercentage(rs.getInt("product_percentage"));
						readallproduct.setDescription(rs.getString("product_description"));
						readallproduct.setCategory(rs.getString("product_category"));
						readallproduct.setCreateddate(rs.getDate("product_createdDate").toLocalDate());
						productList.add(readallproduct);
					}

				}
			}
		} catch (SQLException e) {
			throw new SQLException("Error while reading all product: " + e.getMessage());
		}

		return productList;
	}

//method for searching the product and listing it according to its price range

	public static List<Product> searchingPrice(double fromrange, double torange) throws SQLException, DAOException {

		List<Product> searchprice = new ArrayList<>();

		try (Connection connection = ProductConnection.getConnection()) {

			// creating select statement
			String query = "select * from Product where product_price Between ? AND ? ";

			try (PreparedStatement pst = connection.prepareStatement(query)) {

				pst.setDouble(1, fromrange);
				pst.setDouble(2, torange);

				try (ResultSet resultset = pst.executeQuery()) {
					while (resultset.next()) {
						Product searchproductprice = new Product();
						searchproductprice.setName(resultset.getString("product_name"));
						searchproductprice.setId(resultset.getInt("product_id"));
						searchproductprice.setImageURL(resultset.getString("product_imageUrl"));
						searchproductprice.setPrice(resultset.getDouble("product_price"));
						searchproductprice.setQuantity(resultset.getDouble("product_quantity"));
						searchproductprice.setPercentage(resultset.getInt("product_percentage"));
						searchproductprice.setDescription(resultset.getString("product_description"));
						searchproductprice.setCategory(resultset.getString("product_category"));
						searchproductprice.setCreateddate(resultset.getDate("product_createdDate").toLocalDate());
						searchprice.add(searchproductprice);

					}

				} catch (SQLException e) {

					Logger.info(e.getMessage());
					throw new SQLException("Error occurred.");

				}
			}
		}
		return searchprice;

	}

	public static Product getProductById(int id) throws DAOException, SQLException {

		Product product = new Product();

		try (Connection connection = ProductConnection.getConnection()) {
			// Create update statement using task id

			String query = "SELECT * FROM Product WHERE product_id = ? ";

			try (PreparedStatement pst = connection.prepareStatement(query)) {

				pst.setInt(1, id);

				try (ResultSet rs = pst.executeQuery()) {

					if (rs.next()) {

						product.setName(rs.getString("product_name"));
						product.setImageURL(rs.getString("product_imageUrl"));
						product.setPrice(rs.getDouble("product_price"));
						product.setQuantity(rs.getDouble("product_quantity"));
						product.setPercentage(rs.getInt("product_percentage"));
						product.setDescription(rs.getString("product_description"));
						product.setCategory(rs.getString("product_category"));
						product.setCreateddate(rs.getDate("product_createdDate").toLocalDate());
						return product;
					}

				}
			}
		} catch (SQLException e) {
			throw new DAOException("Error occurred", e);
		}

		return product;
	}

}