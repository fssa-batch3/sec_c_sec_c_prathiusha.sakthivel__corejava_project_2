package com.fssa.greenfarm.model;

import com.fssa.greenfarm.enums.Category;
import com.fssa.greenfarm.enums.Gender;
import com.fssa.greenfarm.enums.OwnershipType;

public class Seller {
    private String name;
    private OwnershipType ownershipType;
    private Gender gender;
    private String email;
    private String address;
    private String district;
    private String state;
    private String bankname;
    private String branchname;
    private Category category;
    private String farmimage;
    private String feedback;

    public Seller(String name, String email, String address, String district, String state, String bankname, String branchname,
                  Category category, String farmimage, String feedback) {
        this.name = name;
        this.email = email; 
        this.address = address;
        this.district = district;
        this.state = state;
        this.bankname = bankname;
        this.branchname = branchname;
        this.category = category;
        this.farmimage = farmimage;
        this.feedback = feedback;
    }


	public Seller() {
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

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public OwnershipType getOwnershipType() {
        return ownershipType;
    }

    public void setOwnershipType(OwnershipType ownershipType) {
        this.ownershipType = ownershipType;
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


    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


	public void setCategory(String string) {
		
	}


	public void setOwnershipType(String string) {
		
	}


	public void setGender(String string) {
		
	}
    
}
