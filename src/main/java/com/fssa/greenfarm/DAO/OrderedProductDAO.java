package com.fssa.greenfarm.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fssa.greenfarm.enums.PaymentMethod;
import com.fssa.greenfarm.exception.DAOException;
import com.fssa.greenfarm.logger.Logger;
import com.fssa.greenfarm.model.Order;
import com.fssa.greenfarm.model.OrderedProduct;

public class OrderedProductDAO {
	
	public static List<Order> getOrderById(int id) throws SQLException, DAOException {

		List<Order> productList = new ArrayList<>();

		try (Connection connection = ProductConnection.getConnection()) {

			// creating select statement
			String query = "SELECT * FROM OrderDetails WHERE `user_id` = ?";

			try (PreparedStatement pst = connection.prepareStatement(query)) {
				
				pst.setInt(1, id);
				
				try (ResultSet resultset = pst.executeQuery()) { 
					
					while (resultset.next()) {
						Order orderProduct = new Order();
						orderProduct.setOrder_id(resultset.getInt("order_id"));
						orderProduct.setAddress(resultset.getString("address"));
						orderProduct.setCity(resultset.getString("city"));
						orderProduct.setState(resultset.getString("state"));
						orderProduct.setPincode(resultset.getInt("pincode"));
						orderProduct.setMobile_number(resultset.getLong("mobile_number"));
						orderProduct.setPaymentmethod(PaymentMethod.CASHONDELIVERY);
						orderProduct.setOrderdate(LocalDate.now());
						orderProduct.setOrderedProducts(getAllOrderedProduct(resultset.getInt("order_id")));
						productList.add(orderProduct);

					}

				} catch (SQLException e) {

					Logger.info(e.getMessage());
					e.printStackTrace();
					throw new SQLException("Error occurred.");

				}
			}
		}
		return productList;

	}
	
	

	public static List<OrderedProduct> getAllOrderedProduct(int orderId) throws SQLException, DAOException {// naming convention

		List<OrderedProduct> productList = new ArrayList<>();

		try (Connection con = ProductConnection.getConnection()) {
			// creating query
			String query = "SELECT * FROM OrderedProduct where order_id= ? ";

			try (PreparedStatement pst = con.prepareStatement(query)) {

				pst.setInt(1, orderId);
				try (ResultSet rs = pst.executeQuery()) {

					
					while (rs.next()) {
						OrderedProduct productorder = new OrderedProduct();
						productorder.setProductId(rs.getInt("productId"));
						productorder.setProductname(rs.getString("productName"));
						productorder.setProductPrice(rs.getDouble("productPrice"));
						productorder.setQuantity(rs.getDouble("productQuantity"));
						productorder.setTotalAmount(rs.getDouble("productTotalAmount"));
						productorder.setStatus(rs.getInt("status"));
						productList.add(productorder);
					}

				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("Error while reading all product: " + e.getMessage());
		}

		return productList;
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



}
