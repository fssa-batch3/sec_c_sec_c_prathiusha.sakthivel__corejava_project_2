package com.fssa.greenfarm.DAO;

import java.sql.Connection;
import java.sql.Date;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fssa.greenfarm.enums.PaymentMethod;
import com.fssa.greenfarm.exception.DAOException;
import com.fssa.greenfarm.logger.Logger;
import com.fssa.greenfarm.model.Order;
import com.fssa.greenfarm.model.OrderedProduct;

public class OrderDAO {

	public boolean createOrder(Order order) throws DAOException {

		try (Connection connection = ProductConnection.getConnection()) {

			String insertQuery = "INSERT INTO OrderDetails (address,city,state,pincode,mobile_number,payment_method,orderdate,user_id) VALUES (?,?,?,?,?,?,?,?)";

			try (PreparedStatement psmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS)) {

				psmt.setString(1, order.getAddress());
				psmt.setString(2, order.getCity());
				psmt.setString(3, order.getState());
				psmt.setInt(4, order.getPincode());
				psmt.setLong(5, order.getMobile_number());
				psmt.setString(6, order.getPaymentmethod() + "");
				psmt.setDate(7, Date.valueOf(LocalDate.now()));
				psmt.setInt(8, order.getUser_id());
				int rows = psmt.executeUpdate();

				System.out.println(rows + "row/rows affected");

				int orderId = 1;

				try (ResultSet rs = psmt.getGeneratedKeys()) {
					
					if (rs.next()) {
						orderId = rs.getInt(1);
						System.out.println("order_id" + orderId);
					}

				}
				
				placeOrderedProduct(order.getOrderedProducts(), orderId);

				return true;

			} catch (SQLException e) {
				throw new DAOException("Error while executing the insert query: " + e.getMessage(), e);
			}
		} catch (SQLException e) {
			throw new DAOException("Error while connecting to the database: " + e.getMessage(), e);
		}

	}

	public boolean placeOrderedProduct(List<OrderedProduct> orderedProducts, int orderId)
			throws DAOException, SQLException {

		if (orderId == -1) {
			return true;
		}
		try (Connection con = ProductConnection.getConnection()) {

			for (OrderedProduct orderedProduct : orderedProducts) {

				String query = "INSERT INTO OrderedProduct (productId, productName, productPrice,productQuantity,productTotalAmount, order_id) VALUES (?, ?, ?,?,?,?)";

				try (PreparedStatement pst = con.prepareStatement(query)) {

					pst.setInt(1, orderedProduct.getProductId());
					pst.setString(2, orderedProduct.getProductname());
					pst.setDouble(3, orderedProduct.getProductPrice());
					pst.setDouble(4, orderedProduct.getQuantity());
					pst.setDouble(5, orderedProduct.getTotalAmount());
					pst.setInt(6, orderId);
					pst.executeUpdate();
					Logger.info("Added ordered products successfully!");

				} catch (SQLException ex) {
					System.out.println(ex.getMessage());
					ex.printStackTrace();
					throw new DAOException("Place OrderedProduct Method Is Failded");
				}
			}
		}

		return true;

	}

	public ArrayList<Order> getOrderById(int userId) throws DAOException {
		try (Connection connection = ProductConnection.getConnection()) {
			String query = "SELECT * FROM `OrderDetails` WHERE user_id = ?";
			try (PreparedStatement pst = connection.prepareStatement(query)) {
				pst.setInt(1, userId);

				try (ResultSet resultSet = pst.executeQuery()) {
					ArrayList<Order> orders = new ArrayList<Order>();
					while (resultSet.next()) {
						Order order = new Order();
						order.setOrder_id(resultSet.getInt("order_id"));
						order.setAddress(resultSet.getString("address"));
						order.setCity(resultSet.getString("city"));
						order.setState(resultSet.getString("state"));
						order.setPincode(resultSet.getInt("pincode"));
						order.setMobile_number(resultSet.getLong("mobile_number"));
						order.setPaymentmethod(PaymentMethod.CASHONDELIVERY);
						order.setOrderedProducts(getOrderedProductsByOrderId(resultSet.getInt("order_id")));
						orders.add(order);

					}
					return orders;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("error Occured");
		}

	}

	public ArrayList<OrderedProduct> getOrderedProductsByOrderId(int orderId) throws DAOException {
		try (Connection connection = ProductConnection.getConnection()) {
			String query = "SELECT * FROM OrderedProduct WHERE user_id = ?";
			try (PreparedStatement pst = connection.prepareStatement(query)) {
				pst.setInt(1, orderId);
				ArrayList<OrderedProduct> orderProducts = new ArrayList<OrderedProduct>();

				try (ResultSet resultSet = pst.executeQuery()) {
					while (resultSet.next()) {
						OrderedProduct orderProduct = new OrderedProduct();
						orderProduct.setProductId(resultSet.getInt("productId"));
						orderProduct.setProductname(resultSet.getString("productName"));
						orderProduct.setProductPrice(resultSet.getDouble("productPrice"));
						orderProduct.setTotalAmount(resultSet.getDouble("productTotalAmount"));
						orderProduct.setQuantity(resultSet.getDouble("productQuantity"));
						orderProducts.add(orderProduct);
					}
					return orderProducts;
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("Error Ocuured");
		}

	}

	public static boolean cancelOrder(int orderId) throws DAOException {
		
		String updateQuery = "UPDATE `OrderedProduct` SET status = '0' WHERE order_id = ?";

		try (Connection connection = ProductConnection.getConnection();

			PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
			preparedStatement.setInt(1, orderId);
			int rowsAffected = preparedStatement.executeUpdate();
			System.out.println("order id : " + orderId + " is cancelled successfully");
			return rowsAffected > 0; // Return true if the order was canceled successfully
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}
	}
}
