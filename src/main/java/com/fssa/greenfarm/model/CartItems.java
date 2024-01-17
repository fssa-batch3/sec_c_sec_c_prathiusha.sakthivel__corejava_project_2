package com.fssa.greenfarm.model;

public class CartItems {
	private int cart_id;
	private int user_id;
	private int product_id;
	private float totalprice;
	private float quantity;
	private boolean status;

	public int getCart_id() {
		return cart_id;
	}

	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
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

	public float getQuantity() {
		return quantity;
	}

	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}

	public float getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(float totalprice) {
		this.totalprice = totalprice;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "CartItems [cart_id=" + cart_id + ", user_id=" + user_id + ", product_id=" + product_id + ", totalprice="
				+ totalprice + ", quantity=" + quantity + ", status=" + status + "]";
	}

}
