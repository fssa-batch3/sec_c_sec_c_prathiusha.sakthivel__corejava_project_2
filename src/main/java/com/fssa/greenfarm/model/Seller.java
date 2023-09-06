package com.fssa.greenfarm.model;

public class Seller {
	//
	// private data members
	private String name;
	private OwnershipType ownershiptype;
	private Gender gender;
	private String email;
	private String address;
	private String district;
	private String state;
	private int pincode;
	private Category category;
	private double squarefeet;
	private String bankname;
	private String branchname;
	private String mentioned;
	private String farmimage;
	private String feedback;

	public Seller(String name,OwnershipType ownershiptype,Gender gender, String email, String address, String district, String state, int pincode,
			Category category, double squarefeet, String bankname, String branchname, String mentioned,
			String farmimage, String feedback) {
		super();
		this.name = name;
		this.email = email;
		this.address = address;
		this.district = district;
		this.state = state;
		this.pincode = pincode;
		this.squarefeet = squarefeet;
		this.bankname = bankname;
		this.branchname = branchname;
		this.mentioned = mentioned;
		this.farmimage = farmimage;
		this.feedback = feedback;
	}

	public String getName() {
		return name;
	} 

	public void setName(String name) {
		this.name = name;
	}

	public OwnershipType getOwnershiptype() {
		return ownershiptype;
	}

	public void setOwnershiptype(OwnershipType ownershiptype) {
		this.ownershiptype = ownershiptype;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
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
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Seller(OwnershipType ownershiptype, Gender gender) {
		super();
		this.ownershiptype = ownershiptype;
		this.gender = gender;
	}

	public double getSquarefeet() {
		return squarefeet;
	}

	public void setSquarefeet(double squarefeet) {
		this.squarefeet = squarefeet;
	}

	public String getBankname() {
		return bankname;
	}

	public void setBankname(String bankname) {
		this.bankname = bankname;
	}

	public String getBranchname() {
		return branchname;
	}

	public void setBranchname(String branchname) {
		this.branchname = branchname;
	}

	public String getMentioned() {
		return mentioned;
	}

	public void setMentioned(String mentioned) {
		this.mentioned = mentioned;
	}

	public String getFarmimage() {
		return farmimage;
	}

	public void setFarmimage(String farmimage) {
		this.farmimage = farmimage;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

}