<<<<<<< Updated upstream
package com.fssa.greenfarm.validator;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.greenfarm.customerrors.OrderValidatorErrors;
import com.fssa.greenfarm.enums.PaymentMethod;
import com.fssa.greenfarm.exception.InValidOrderDetailException;
import com.fssa.greenfarm.model.Order;

public class OrderValidator {
	
	// Method to checks the validity of the product
	public static boolean validate(Order order) throws InValidOrderDetailException {

		// It checks for the product if it is null or not
		// If the product is null it will throw an exception
		if (order == null) {
			throw new InValidOrderDetailException(OrderValidatorErrors.INVALID_ORDER_DETAIL);
		}
		validateOrderAddress(order.getAddress());
		validateOrderCity(order.getCity());
		validateOrderState(order.getState());
		validateOrderPincode(order.getPincode());
		validateOrderMobileNumber(order.getMobile_number());
		validateOrderPaymentMethod(order.getPaymentmethod());
 
		return true;

	}




	public static boolean validateOrderAddress(String address) throws InValidOrderDetailException {
		if(address == null || "".equals(address.trim())) {
			throw new InValidOrderDetailException(OrderValidatorErrors.INVALID_ORDER_ADDRESS);
		}
		String addressRegex = "^[a-zA-Z0-9 ,.'-]+$";
		Pattern pattern = Pattern.compile(addressRegex);
		Matcher matcher = pattern.matcher(address);
		boolean isMatch = matcher.matches();

		if (!isMatch) {
			throw new IllegalArgumentException("The address is invalid");
		}

		return true;
	}

	public static void validateOrderCity(String city) throws InValidOrderDetailException {
		if (city == null || "".equals(city.trim()) || city.length() < 2) {
			throw new InValidOrderDetailException(OrderValidatorErrors.INVALID_CITY);
		}
	}

	public static void validateOrderState(String state) throws InValidOrderDetailException {
		if (state == null || "".equals(state.trim()) || state.length() < 2) {
			throw new InValidOrderDetailException(OrderValidatorErrors.INVALID_STATE);
		}
	}

	public static boolean validateOrderPincode(int pincode) throws InValidOrderDetailException {	
		 String pincodeStr = String.valueOf(pincode);

		    if (pincodeStr.length() == 6 && pincodeStr.matches("\\d+")) {
		        return true; //valid pincode
		    } else {
		        throw new InValidOrderDetailException(OrderValidatorErrors.INVALID_PINCODE);
		    }
	}

	public static boolean validateOrderMobileNumber(long mobile_number) throws InValidOrderDetailException {
		   String mobileNumberStr = String.valueOf(mobile_number);

		    if (mobileNumberStr.length() == 10 && mobileNumberStr.matches("\\d+")) {
		        return true; // Valid mobile number
		    } else {
		        throw new InValidOrderDetailException(OrderValidatorErrors.INVALID_MOBILE_NUMBER);
		    }
		
	}

	public static boolean validateOrderPaymentMethod(PaymentMethod paymentmethod) throws InValidOrderDetailException {
		   if (paymentmethod == PaymentMethod.UPI || paymentmethod == PaymentMethod.CARD || paymentmethod == PaymentMethod.CASHONDELIVERY) {
		        return true; // Valid payment method
		    } else {
		        throw new InValidOrderDetailException(OrderValidatorErrors.INVALID_PAYMENT_METHOD);
		    }
	}

	public static boolean validateOrderId(int order_id) throws InValidOrderDetailException {
		if(order_id >= 0 && order_id <= 1000) {
			throw new InValidOrderDetailException(OrderValidatorErrors.INVALID_ORDER_ID);
		}
		
		return false;
	}
	 
	public static boolean validateUserId(int user_id) throws InValidOrderDetailException {
		if(user_id <= 0) {
			throw new InValidOrderDetailException(OrderValidatorErrors.INVALID_USER_ID);
		}
		
		return false;
	}


}
=======
package com.fssa.greenfarm.validator;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.greenfarm.customerrors.OrderValidatorErrors;
import com.fssa.greenfarm.enums.PaymentMethod;
import com.fssa.greenfarm.exception.InValidOrderDetailException;
import com.fssa.greenfarm.model.Order;

public class OrderValidator {
	
	// Method to checks the validity of the product
	public static boolean validate(Order order) throws InValidOrderDetailException {

		// It checks for the product if it is null or not
		// If the product is null it will throw an exception
		if (order == null) {
			throw new InValidOrderDetailException(OrderValidatorErrors.INVALID_ORDER_DETAIL);
		}
		validateOrderAddress(order.getAddress());
		validateOrderCity(order.getCity());
		validateOrderState(order.getState());
		validateOrderPincode(order.getPincode());
		validateOrderMobileNumber(order.getMobile_number());
		validateOrderPaymentMethod(order.getPaymentmethod());
 
		return true;

	}




	public static boolean validateOrderAddress(String address) throws InValidOrderDetailException {
		if(address == null || "".equals(address.trim())) {
			throw new InValidOrderDetailException(OrderValidatorErrors.INVALID_ORDER_ADDRESS);
		}
		String addressRegex = "^[a-zA-Z0-9 ,.'-]+$";
		Pattern pattern = Pattern.compile(addressRegex);
		Matcher matcher = pattern.matcher(address);
		boolean isMatch = matcher.matches();

		if (!isMatch) {
			throw new IllegalArgumentException("The address is invalid");
		}

		return true;
	}

	public static void validateOrderCity(String city) throws InValidOrderDetailException {
		if (city == null || "".equals(city.trim()) || city.length() < 2) {
			throw new InValidOrderDetailException(OrderValidatorErrors.INVALID_CITY);
		}
	}

	public static void validateOrderState(String state) throws InValidOrderDetailException {
		if (state == null || "".equals(state.trim()) || state.length() < 2) {
			throw new InValidOrderDetailException(OrderValidatorErrors.INVALID_STATE);
		}
	}

	public static boolean validateOrderPincode(int pincode) throws InValidOrderDetailException {	
		 String pincodeStr = String.valueOf(pincode);

		    if (pincodeStr.length() == 6 && pincodeStr.matches("\\d+")) {
		        return true; //valid pincode
		    } else {
		        throw new InValidOrderDetailException(OrderValidatorErrors.INVALID_PINCODE);
		    }
	}

	public static boolean validateOrderMobileNumber(long mobile_number) throws InValidOrderDetailException {
		   String mobileNumberStr = String.valueOf(mobile_number);

		    if (mobileNumberStr.length() == 10 && mobileNumberStr.matches("\\d+")) {
		        return true; // Valid mobile number
		    } else {
		        throw new InValidOrderDetailException(OrderValidatorErrors.INVALID_MOBILE_NUMBER);
		    }
		
	}

	public static boolean validateOrderPaymentMethod(PaymentMethod paymentmethod) throws InValidOrderDetailException {
		   if (paymentmethod == PaymentMethod.UPI || paymentmethod == PaymentMethod.CARD || paymentmethod == PaymentMethod.CASHONDELIVERY) {
		        return true; // Valid payment method
		    } else {
		        throw new InValidOrderDetailException(OrderValidatorErrors.INVALID_PAYMENT_METHOD);
		    }
	}

	public static boolean validateOrderId(int order_id) throws InValidOrderDetailException {
		if(order_id >= 0 && order_id <= 1000) {
			throw new InValidOrderDetailException(OrderValidatorErrors.INVALID_ORDER_ID);
		}
		
		return false;
	}
	 
	public static boolean validateUserId(int user_id) throws InValidOrderDetailException {
		if(user_id <= 0) {
			throw new InValidOrderDetailException(OrderValidatorErrors.INVALID_USER_ID);
		}
		
		return false;
	}


}
>>>>>>> Stashed changes
