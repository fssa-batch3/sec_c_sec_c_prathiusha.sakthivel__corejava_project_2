<<<<<<< Updated upstream
package com.fssa.greenfarm.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;

import com.fssa.greenfarm.exception.DAOException;
import com.fssa.greenfarm.logger.Logger;
import com.fssa.greenfarm.model.CartItems;

public class CartDAO {

	public static void addToCart(CartItems cart) throws DAOException, SQLException {

		try (Connection connection = ProductConnection.getConnection()) {
			String insertQuery = "INSERT INTO `CartItems` (cart_id, product_id, user_id, totalprice,quantity,status) VALUES (?, ?, ?,?,?,?)";

			try (PreparedStatement pst = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS)) {

				pst.setInt(1, cart.getCart_id());
				pst.setInt(2, cart.getProduct_id());
				pst.setInt(3, cart.getUser_id());
				pst.setFloat(4, cart.getTotalprice());
				pst.setFloat(5, cart.getQuantity());
				pst.setBoolean(6, cart.getStatus());

				int rows = pst.executeUpdate();

				int cartId;

				if (rows == 0) {
					throw new SQLException("Adding failed");
				}

				try (ResultSet generatedKeys = pst.getGeneratedKeys()) {
					if (generatedKeys.next()) {
						cartId = generatedKeys.getInt(1);
						System.out.println(cartId);
					}
				}
				Logger.info(rows);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void addingCartItems(ArrayList<CartItems> cartDetails, int cartId) throws DAOException, SQLException {

		try (Connection connection = ProductConnection.getConnection()) {
			String query = "INSERT INTO CartItems (cart_id, product_id, user_id, totalprice,quantity,status) VALUES (?, ?, ?, ?,?,?)";

			try (PreparedStatement pst = connection.prepareStatement(query)) {

				for (CartItems cartDetail : cartDetails) {

					pst.setInt(1, cartId);
					pst.setInt(2, cartDetail.getProduct_id());
					pst.setInt(3, cartDetail.getUser_id());
					pst.setFloat(4, cartDetail.getTotalprice());
					pst.setFloat(5, cartDetail.getQuantity());
					pst.setBoolean(6, cartDetail.getStatus());

					pst.executeUpdate();
				}
				Logger.info("Products ordered to cart successfully");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static ArrayList<CartItems> getCartItemsByUserId(int userid) throws DAOException, SQLException {
		try (Connection con = ProductConnection.getConnection()) {
			CartItems cart = null;
			String query = "SELECT * from CartItems where user_id=?";

			ArrayList<CartItems> cartDetails = new ArrayList<CartItems>();

			try (Connection connection = ProductConnection.getConnection()) {

				try (PreparedStatement psmt = connection.prepareStatement(query)) {
					psmt.setInt(1, userid);
					try (ResultSet rs = psmt.executeQuery()) {
						while (rs.next()) {
							cart = new CartItems();
							cart.setCart_id(rs.getInt("cart_id"));
							cart.setProduct_id(rs.getInt("product_id"));
							cart.setUser_id(rs.getInt("user_id"));
							cart.setTotalprice(rs.getFloat("totalprice"));
							cart.setQuantity(rs.getFloat("quantity"));
							cart.setStatus(rs.getBoolean("status"));
							cartDetails.add(cart);
						}
					}
				}
			}
			return cartDetails;

		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}

	}

	public static int getCartIdByProductId(int productId, int userId) throws DAOException, SQLException {

		String query = "select cart_id from CartItems where product_id = ? AND  user_id=?";
		int cartId = -1;
		try (Connection connection = ProductConnection.getConnection()) {
			try (PreparedStatement psmt = connection.prepareStatement(query)) {

				psmt.setInt(1, productId);
				psmt.setInt(2, userId);

				ResultSet rs = psmt.executeQuery();

				if (rs.next()) {

					return rs.getInt("cart_id");
				}
			}
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}
		return cartId;
	}
	

	public static void removeCartItemsByCartId(int cartId) throws DAOException, SQLException {

		String query = "Delete from CartItems where cart_id = ?";

		try (Connection connection = ProductConnection.getConnection()) {
			try (PreparedStatement psmt = connection.prepareStatement(query)) {

				psmt.setInt(1, cartId);

				int rowsUpdated = psmt.executeUpdate();

				if (rowsUpdated > 0) {

					System.out.println("deleted successfully");
				} else {

					System.out.println("Not found" + cartId);
				}
			}
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}

	}

	public static ArrayList<CartItems> getCartItemsByCartId(int cart_Id) throws DAOException, SQLException {
		try (Connection con = ProductConnection.getConnection()) {
			CartItems cart = null;
			String query = "SELECT * from CartItems where cart_id=?";

			ArrayList<CartItems> cartDetails = new ArrayList<CartItems>();

			try (Connection connection = ProductConnection.getConnection()) {

				try (PreparedStatement psmt = connection.prepareStatement(query)) {
					psmt.setInt(1, cart_Id);
					try (ResultSet rs = psmt.executeQuery()) {
						while (rs.next()) {
							cart = new CartItems();
							cart.setCart_id(rs.getInt("cart_id"));
							cart.setProduct_id(rs.getInt("product_id"));
							cart.setUser_id(rs.getInt("user_id"));
							cart.setTotalprice(rs.getFloat("totalprice"));
							cart.setQuantity(rs.getFloat("quantity"));
							cart.setStatus(rs.getBoolean("status"));
							cartDetails.add(cart);
						}
					}
				}
			}
			return cartDetails;

		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}

	}

	

}
=======
package com.fssa.greenfarm.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.fssa.greenfarm.exception.DAOException;
import com.fssa.greenfarm.logger.Logger;
import com.fssa.greenfarm.model.CartItems;
import com.fssa.greenfarm.util.ConnectionUtil;

public class CartDAO {

	public static void addToCart(CartItems cart) throws DAOException, SQLException {

		try (Connection connection = ConnectionUtil.getConnection()) {
			String insertQuery = "INSERT INTO `CartItems` (cart_id, product_id, user_id, totalprice,quantity,status) VALUES (?, ?, ?,?,?,?)";

			try (PreparedStatement pst = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS)) {

				pst.setInt(1, cart.getCart_id());
				pst.setInt(2, cart.getProduct_id());
				pst.setInt(3, cart.getUser_id());
				pst.setFloat(4, cart.getTotalprice());
				pst.setFloat(5, cart.getQuantity());
				pst.setBoolean(6, cart.getStatus());

				int rows = pst.executeUpdate();

				int cartId;

				if (rows == 0) {
					throw new SQLException("Adding failed");
				}

				try (ResultSet generatedKeys = pst.getGeneratedKeys()) {
					if (generatedKeys.next()) {
						cartId = generatedKeys.getInt(1);
						System.out.println(cartId);
					}
				}
				Logger.info(rows);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void addingCartItems(ArrayList<CartItems> cartDetails, int cartId) throws DAOException, SQLException {

		try (Connection connection = ConnectionUtil.getConnection()) {
			String query = "INSERT INTO CartItems (cart_id, product_id, user_id, totalprice,quantity,status) VALUES (?, ?, ?, ?,?,?)";

			try (PreparedStatement pst = connection.prepareStatement(query)) {

				for (CartItems cartDetail : cartDetails) {

					pst.setInt(1, cartId);
					pst.setInt(2, cartDetail.getProduct_id());
					pst.setInt(3, cartDetail.getUser_id());
					pst.setFloat(4, cartDetail.getTotalprice());
					pst.setFloat(5, cartDetail.getQuantity());
					pst.setBoolean(6, cartDetail.getStatus());

					pst.executeUpdate();
				}
				Logger.info("Products ordered to cart successfully");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static ArrayList<CartItems> getCartItemsByUserId(int userid) throws DAOException, SQLException {
		try (Connection con = ConnectionUtil.getConnection()) {
			CartItems cart = null;
			String query = "SELECT * from CartItems where user_id=?";

			ArrayList<CartItems> cartDetails = new ArrayList<CartItems>();

			try (Connection connection = ConnectionUtil.getConnection()) {

				try (PreparedStatement psmt = connection.prepareStatement(query)) {
					psmt.setInt(1, userid);
					try (ResultSet rs = psmt.executeQuery()) {
						while (rs.next()) {
							cart = new CartItems();
							cart.setCart_id(rs.getInt("cart_id"));
							cart.setProduct_id(rs.getInt("product_id"));
							cart.setUser_id(rs.getInt("user_id"));
							cart.setTotalprice(rs.getFloat("totalprice"));
							cart.setQuantity(rs.getFloat("quantity"));
							cart.setStatus(rs.getBoolean("status"));
							cartDetails.add(cart);
						}
					}
				}
			}
			return cartDetails;

		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}

	}

	public static int getCartIdByProductId(int productId, int userId) throws DAOException, SQLException {

		String query = "select cart_id from CartItems where product_id = ? AND  user_id=?";
		int cartId = -1;
		try (Connection connection = ConnectionUtil.getConnection()) {
			try (PreparedStatement psmt = connection.prepareStatement(query)) {

				psmt.setInt(1, productId);
				psmt.setInt(2, userId);

				ResultSet rs = psmt.executeQuery();

				if (rs.next()) {

					return rs.getInt("cart_id");
				}
			}
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}
		return cartId;
	}
	

	public static void removeCartItemsByCartId(int cartId) throws DAOException, SQLException {

		String query = "Delete from CartItems where cart_id = ?";

		try (Connection connection = ConnectionUtil.getConnection()) {
			try (PreparedStatement psmt = connection.prepareStatement(query)) {

				psmt.setInt(1, cartId);

				int rowsUpdated = psmt.executeUpdate();

				if (rowsUpdated > 0) {

					System.out.println("deleted successfully");
				} else {

					System.out.println("Not found" + cartId);
				}
			}
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}

	}

	public static ArrayList<CartItems> getCartItemsByCartId(int cart_Id) throws DAOException, SQLException {
		try (Connection con = ConnectionUtil.getConnection()) {
			CartItems cart = null;
			String query = "SELECT * from CartItems where cart_id=?";

			ArrayList<CartItems> cartDetails = new ArrayList<CartItems>();

			try (Connection connection = ConnectionUtil.getConnection()) {

				try (PreparedStatement psmt = connection.prepareStatement(query)) {
					psmt.setInt(1, cart_Id);
					try (ResultSet rs = psmt.executeQuery()) {
						while (rs.next()) {
							cart = new CartItems();
							cart.setCart_id(rs.getInt("cart_id"));
							cart.setProduct_id(rs.getInt("product_id"));
							cart.setUser_id(rs.getInt("user_id"));
							cart.setTotalprice(rs.getFloat("totalprice"));
							cart.setQuantity(rs.getFloat("quantity"));
							cart.setStatus(rs.getBoolean("status"));
							cartDetails.add(cart);
						}
					}
				}
			}
			return cartDetails;

		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}

	}
}
>>>>>>> Stashed changes
