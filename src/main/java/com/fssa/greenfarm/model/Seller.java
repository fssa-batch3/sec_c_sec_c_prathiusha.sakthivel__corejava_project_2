package com.fssa.greenfarm.model;

public class Seller {
	//
	// private data members
	private String name;
	private String email;
	private String address;
	private String district;
	private String state;
	private String bankname;
	private String branchname;
	private String farmimage;
	private String feedback;

	public Seller(String name, String email, String address, String district, String state, String bankname, String branchname, 
			String farmimage, String feedback) {
		super();
		this.name = name;
		this.email = email;
		this.address = address;
		this.district = district;
		this.state = state;
		this.bankname = bankname;
		this.branchname = branchname;
		this.farmimage = farmimage;
		this.feedback = feedback;
	}

	public String getName() {
		return name;
	} 

	public void setName(String name) {
		this.name = name;
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