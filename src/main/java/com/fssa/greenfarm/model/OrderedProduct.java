<<<<<<< Updated upstream
package com.fssa.greenfarm.model;

public class OrderedProduct {
	
	private int productId;
	private String productname;
	private double productPrice;
	private double quantity;
	
	private int status;
 
    
	public OrderedProduct(int productId, String productname, double productPrice, double quantity, double totalAmount) {
		super();
		this.productId = productId;
		this.productname = productname;
		this.productPrice = productPrice;
		this.quantity = quantity; 
		this.totalAmount = totalAmount;
	} 

	public OrderedProduct() {
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	private double totalAmount;


	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	

}
=======
package com.fssa.greenfarm.model;

public class OrderedProduct {
	
	private int productId;
	private String productname;
	private double productPrice;
	private double quantity;
	
	private int status;
 
    
	public OrderedProduct(int productId, String productname, double productPrice, double quantity, double totalAmount) {
		super();
		this.productId = productId;
		this.productname = productname;
		this.productPrice = productPrice;
		this.quantity = quantity; 
		this.totalAmount = totalAmount;
	} 

	public OrderedProduct() {
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	private double totalAmount;


	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	

}
>>>>>>> Stashed changes
