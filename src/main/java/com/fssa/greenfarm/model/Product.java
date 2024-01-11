package com.fssa.greenfarm.model;

import java.time.LocalDate;

public class Product {

	// private data members or attributes
	private String name;
	private int id;
	private String imageURL;
	private double price;
	private double quantity;
	private int percentage;
	private String description; 
	private String category;
	private LocalDate createddate;

	// creating a constructor for the attribute
	public Product(String name, int id, String imageURL, double price, double quantity, int percentage,
			String description, String category, LocalDate createddate) {

		this.name = name;
		this.id = id;
		this.imageURL = imageURL;
		this.price = price;
		this.quantity = quantity;
		this.percentage = percentage;
		this.description = description;
		this.category = category;
		this.createddate = createddate;
	}

	public Product(String productName, int i, String string, int j, double d, String string2, String string3) {
	}

	public Product() {
	}

	// setters and getter methods in public for accessing the private data members
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public int getPercentage() {
		return percentage;
	}

	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public LocalDate getCreateddate() {
		return createddate;
	}

	public void setCreateddate(LocalDate createddate) {
		this.createddate = createddate;
	}

}
