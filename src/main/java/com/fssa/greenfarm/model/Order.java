<<<<<<< Updated upstream
package com.fssa.greenfarm.model;

import java.time.LocalDate;
import java.util.List;

import com.fssa.greenfarm.enums.OrderStatus;
import com.fssa.greenfarm.enums.PaymentMethod;


public class Order {
 
	private int product_id;
	private int user_id;
	private int order_id;
	private String address;
	private String city;
	private LocalDate orderdate;
	
	public LocalDate getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(LocalDate orderdate) {
		this.orderdate = orderdate;
	}

	public OrderStatus getStatus() {
		return status;
		
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	private String state;
	private int pincode;
	private long mobile_number;
    private PaymentMethod paymentmethod; 
	private List<OrderedProduct> orderedProducts; 
	private OrderStatus status;
    
	public List<OrderedProduct> getOrderedProducts() {
		return orderedProducts;
	}

	public void setOrderedProducts(List<OrderedProduct> orderedProducts) {
		this.orderedProducts = orderedProducts;
	}


	public Order(int product_id,int user_id, int order_id, String address, String city, String state, int pincode, long mobile_number,
			PaymentMethod paymentmethod) {
		super();
		this.user_id = user_id;
		this.order_id = order_id;
		this.address = address;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.mobile_number = mobile_number;
		this.paymentmethod = paymentmethod;
	}

	public Order() {
	}
	 
	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	} 

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public long getMobile_number() {
		return mobile_number;
	}

	public void setMobile_number(long mobile_number) {
		this.mobile_number = mobile_number;
	}

	@Override
	public String toString() {
		return "Order [product_id=" + product_id + ", user_id=" + user_id + ", order_id=" + order_id + ", address="
				+ address + ", city=" + city + ", orderdate=" + orderdate + ", state=" + state + ", pincode=" + pincode
				+ ", mobile_number=" + mobile_number + ", paymentmethod=" + paymentmethod + ", orderedProducts="
				+ orderedProducts + ", status=" + status + "]";
	}

	public PaymentMethod getPaymentmethod() {
		return paymentmethod;
	}

	public void setPaymentmethod(PaymentMethod paymentmethod) {
		this.paymentmethod = paymentmethod;
	}


}
=======
package com.fssa.greenfarm.model;

import java.time.LocalDate;
import java.util.List;

import com.fssa.greenfarm.enums.OrderStatus;
import com.fssa.greenfarm.enums.PaymentMethod;


public class Order {
 
	private int product_id;
	private int user_id;
	private int order_id;
	private String address;
	private String city;
	private LocalDate orderdate;
	
	public LocalDate getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(LocalDate orderdate) {
		this.orderdate = orderdate;
	}

	public OrderStatus getStatus() {
		return status;
		
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	private String state;
	private int pincode;
	private long mobile_number;
    private PaymentMethod paymentmethod; 
	private List<OrderedProduct> orderedProducts; 
	private OrderStatus status;
    
	public List<OrderedProduct> getOrderedProducts() {
		return orderedProducts;
	}

	public void setOrderedProducts(List<OrderedProduct> orderedProducts) {
		this.orderedProducts = orderedProducts;
	}


	public Order(int product_id,int user_id, int order_id, String address, String city, String state, int pincode, long mobile_number,
			PaymentMethod paymentmethod) {
		super();
		this.user_id = user_id;
		this.order_id = order_id;
		this.address = address;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.mobile_number = mobile_number;
		this.paymentmethod = paymentmethod;
	}

	public Order() {
	}
	 
	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	} 

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public long getMobile_number() {
		return mobile_number;
	}

	public void setMobile_number(long mobile_number) {
		this.mobile_number = mobile_number;
	}

	@Override
	public String toString() {
		return "Order [product_id=" + product_id + ", user_id=" + user_id + ", order_id=" + order_id + ", address="
				+ address + ", city=" + city + ", orderdate=" + orderdate + ", state=" + state + ", pincode=" + pincode
				+ ", mobile_number=" + mobile_number + ", paymentmethod=" + paymentmethod + ", orderedProducts="
				+ orderedProducts + ", status=" + status + "]";
	}

	public PaymentMethod getPaymentmethod() {
		return paymentmethod;
	}

	public void setPaymentmethod(PaymentMethod paymentmethod) {
		this.paymentmethod = paymentmethod;
	}


}
>>>>>>> Stashed changes
