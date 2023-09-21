package com.fssa.greenfarm.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.greenfarm.enums.PaymentMethod;
import com.fssa.greenfarm.exception.DAOException;
import com.fssa.greenfarm.exception.InValidOrderDetailException;
import com.fssa.greenfarm.exception.ProductInvalidException;
import com.fssa.greenfarm.model.Order;
import com.fssa.greenfarm.model.OrderedProduct;
import com.fssa.greenfarm.model.Product;
import com.google.protobuf.ServiceException;

public class TestOrderService {
	@Test
	public void testCreateOrder() throws InValidOrderDetailException, DAOException, SQLException, ServiceException, ProductInvalidException {
		OrderService orderservice = new OrderService();
		
		List<OrderedProduct> productsList = new ArrayList<>();
		
		int productId= 1;
		Product product=ProductService.getProductById(productId);
		
		Order order = new Order();

		OrderedProduct product1 = new OrderedProduct();
		product1.setProductId(productId);
		product1.setProductname(product.getName());
		product1.setProductPrice(product.getPrice());
		product1.setQuantity(1.2);
		product1.setTotalAmount(product.getPrice());

		productsList.add(product1);
		 
		order.setUser_id(1); 
		order.setAddress("15th cross anna nagar");
		order.setCity("chennai");
		order.setState("Tamilnadu"); 
		order.setPincode(1234567);
		order.setMobile_number(1234567890);
		order.setPaymentmethod(PaymentMethod.CASHONDELIVERY);
		
		order.setOrderedProducts(productsList);
		System.out.println(order);
		Assertions.assertTrue(orderservice.createOrder(order));
		
	}
}
