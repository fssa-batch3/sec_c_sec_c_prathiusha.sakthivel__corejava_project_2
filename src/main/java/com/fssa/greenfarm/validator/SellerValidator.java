package com.fssa.greenfarm.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.greenfarm.customerrors.SellerValidatorErrors;
import com.fssa.greenfarm.exception.SellerInvalidException;
import com.fssa.greenfarm.model.Seller;

public class SellerValidator {
	public static boolean validate(Seller seller) throws SellerInvalidException{

		if (seller == null) {
			throw new SellerInvalidException(SellerValidatorErrors.INVALID_SELLER_NULL);
		}
		validateName(seller.getName());
		validateEmail(seller.getEmail());
		validateAddress(seller.getAddress());
		validateDistrict(seller.getDistrict());
		validateState(seller.getState());
		validateBankname(seller.getBankname());
		validateBranchName(seller.getBranchname());
		validateFarmImage(seller.getFarmimage());
		validateFeedback(seller.getFeedback());
		return true;

	}

//
	private static boolean validateName(String name) throws SellerInvalidException {
		if (name == null || "".equals(name.trim()) || name.length() < 2) {
			throw new SellerInvalidException(SellerValidatorErrors.INVALID_NAME);
		}
		return true;
	}

//
	private static boolean validateEmail(String email) {
	    String emailRegex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
	    Pattern pattern = Pattern.compile(emailRegex);
	    Matcher matcher = pattern.matcher(email);

	    if (!matcher.matches()) {
	        throw new IllegalArgumentException("The email is invalid");
	    }

	    return true;
	}
//
	private static boolean validateAddress(String address) {
		String addressRegex = "^[a-zA-Z0-9 ,.'-]+$";
		Pattern pattern = Pattern.compile(addressRegex);
		Matcher matcher = pattern.matcher(address);
		boolean isMatch = matcher.matches();

		if (!isMatch) {
			throw new IllegalArgumentException("The address is invalid");
		}

		return true;

	}
//
	private static boolean validateDistrict(String district) throws SellerInvalidException {
		if (district == null || "".equals(district.trim()) || district.length() < 2) {
			throw new SellerInvalidException(SellerValidatorErrors.INVALID_DISTRICT);
		}
		return true;
	}
//
	private static boolean validateState(String state) throws SellerInvalidException {
		if (state == null || "".equals(state.trim()) || state.length() < 2) {
			throw new SellerInvalidException(SellerValidatorErrors.INVALID_STATE);
		}
		return true;
	}
//
	private static boolean validateBankname(String bankname) throws SellerInvalidException {
		if (bankname == null || "".equals(bankname.trim()) || bankname.length() < 2) {
			throw new SellerInvalidException(SellerValidatorErrors.INVALID_STATE);
		}
		return true;

	}
//
	private static boolean validateBranchName(String branchname) throws SellerInvalidException {
		if (branchname == null || "".equals(branchname.trim()) || branchname.length() < 2) {
			throw new SellerInvalidException(SellerValidatorErrors.INVALID_STATE);
		}
		return true;
	}

//
	
	private static boolean validateFarmImage(String farmimage) throws SellerInvalidException {
		if (farmimage == null || "".equals(farmimage.trim())) {
			throw new SellerInvalidException(SellerValidatorErrors.INVALID_FARMIMAGE);
		}
		String farmImageRegex  = "(http)?s?:?(\\/\\/[^\"']*\\.(?:png|jpg|jpeg|gif|svg))";
		Pattern pattern = Pattern.compile(farmImageRegex );
		Matcher matcher = pattern.matcher(farmimage);
	
		if (matcher.matches()) {
			return true;
		} else {
			throw new SellerInvalidException(SellerValidatorErrors.INVALID_FARMIMAGE);
		}
	}
//
	private static boolean validateFeedback(String feedback) throws SellerInvalidException {
		if (feedback == null || "".equals(feedback.trim()) || feedback.length() < 2) {
			throw new SellerInvalidException(SellerValidatorErrors.INVALID_FEEDBACK);
		}
		return true;
	}

}
