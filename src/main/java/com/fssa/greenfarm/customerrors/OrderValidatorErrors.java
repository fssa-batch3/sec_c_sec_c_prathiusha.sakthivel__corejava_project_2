package com.fssa.greenfarm.customerrors;

public class OrderValidatorErrors {
	
	public static final String INVALID_ORDER_ID = "Order id is invalid it should not less than 1 or should not more than 1000";
	
	public static final String INVALID_USER_ID = "User id is invalid it should not less than 1 or should not more than 1000";

	public static final String INVALID_ORDER_DETAIL = "Order details is invalid";

	public static final String INVALID_ORDER_ADDRESS = "Invalid Order Address";

	public static final String INVALID_CITY = "Invalid Order City";
	
	public static final String INVALID_STATE = "Invalid Order State";

	public static final String INVALID_PINCODE = "Order Pincode Contains only 6 numbers not more than that and it doesnt include any letters or speacial characters";

	public static final String INVALID_MOBILE_NUMBER = "Order Mobile Number  Contains only 10 numbers not more than that and it doesnt include any letters or speacial characters";

	public static final String INVALID_PAYMENT_METHOD = "Order Payment Method is Invalid";

}
