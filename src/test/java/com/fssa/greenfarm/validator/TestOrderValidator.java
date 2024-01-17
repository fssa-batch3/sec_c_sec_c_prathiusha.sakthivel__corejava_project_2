package com.fssa.greenfarm.validator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.greenfarm.customerrors.OrderValidatorErrors;
import com.fssa.greenfarm.enums.PaymentMethod;
import com.fssa.greenfarm.exception.InValidOrderDetailException;

public class TestOrderValidator {
	
	@Test
	public void testValidateOrderAddressValid() throws InValidOrderDetailException {
	    String validAddress = "123 Main Street";
	    assertTrue(OrderValidator.validateOrderAddress(validAddress));
	}
	
	@Test
	public void testValidateOrderAddressNull() {
	    String nullAddress = null;
	    try {
	        OrderValidator.validateOrderAddress(nullAddress);
	        fail("Expected InValidOrderDetailException but no exception was thrown");
	    } catch (InValidOrderDetailException e) {
	        // Expected exception
	    }
	}

	@Test
	public void testValidateOrderAddressEmpty() {
	    String emptyAddress = "";
	    try {
	        OrderValidator.validateOrderAddress(emptyAddress);
	        fail("Expected InValidOrderDetailException but no exception was thrown");
	    } catch (InValidOrderDetailException e) {
	        // Expected exception
	    }
	}
	
	@Test
	public void testValidateOrderCityValid() throws InValidOrderDetailException {
	    String validCity = "Chennai";
	    OrderValidator.validateOrderCity(validCity);
	}
	
	@Test
	public void testValidateOrderCityNull() {
	    String nullCity = null;
	    try {
	        OrderValidator.validateOrderCity(nullCity);
	        fail("Expected InValidOrderDetailException but no exception was thrown");
	    } catch (InValidOrderDetailException e) {
	        // Expected exception
	    }
	}

	@Test
	public void testValidateOrderCityEmpty() {
	    String emptyCity = "";
	    try {
	        OrderValidator.validateOrderCity(emptyCity);
	        fail("Expected InValidOrderDetailException but no exception was thrown");
	    } catch (InValidOrderDetailException e) {
	        // Expected exception
	    }
	}

	@Test
	public void testValidateOrderCityTooShort() {
	    String shortCity = "A";
	    try {
	        OrderValidator.validateOrderCity(shortCity);
	        fail("Expected InValidOrderDetailException but no exception was thrown");
	    } catch (InValidOrderDetailException e) {
	        // Expected exception
	    }
	}
	
	@Test
	public void testValidateOrderStateValid() throws InValidOrderDetailException {
	    String validState = "Tamilnadu";
	    OrderValidator.validateOrderState(validState);
	}
	
	@Test
	public void testValidateOrderStateNull() {
	    String nullState = null;
	    try {
	        OrderValidator.validateOrderState(nullState);
	        fail("Expected InValidOrderDetailException but no exception was thrown");
	    } catch (InValidOrderDetailException e) {
	        // Expected exception
	    }
	}

	@Test
	public void testValidateOrderStateEmpty() {
	    String emptyState = "";
	    try {
	        OrderValidator.validateOrderState(emptyState);
	        fail("Expected InValidOrderDetailException but no exception was thrown");
	    } catch (InValidOrderDetailException e) {
	        // Expected exception
	    }
	}

	@Test
	public void testValidateOrderStateTooShort() {
	    String shortState = "C";
	    try {
	        OrderValidator.validateOrderState(shortState);
	        fail("Expected InValidOrderDetailException but no exception was thrown");
	    } catch (InValidOrderDetailException e) {
	        // Expected exception
	    }
	}
	
	@Test
	public void testValidateOrderPincodeValid() throws InValidOrderDetailException {
	    int validPincode = 123456;
	    assertTrue(OrderValidator.validateOrderPincode(validPincode));
	}
	
	@Test
	public void testValidateOrderPincodeShort() {
	    int shortPincode = 12345;
	    try {
	        OrderValidator.validateOrderPincode(shortPincode);
	        fail("Expected InValidOrderDetailException but no exception was thrown");
	    } catch (InValidOrderDetailException e) {
	        // Expected exception
	    }
	}

	@Test
	public void testValidateOrderPincodeNonNumeric() {
	    int nonNumericPincode = 12345678;
	    try {
	        OrderValidator.validateOrderPincode(nonNumericPincode);
	        fail("Expected InValidOrderDetailException but no exception was thrown");
	    } catch (InValidOrderDetailException e) {
	        // Expected exception
	    }
	}
	@Test
	public void testValidateOrderMobileNumberValid() throws InValidOrderDetailException {
	    long validMobileNumber = 1234567890;
	    assertTrue(OrderValidator.validateOrderMobileNumber(validMobileNumber));
	}
	
	@Test
	public void testValidateOrderMobileNumberShort() {
	    long shortMobileNumber = 12345678;
	    try {
	        OrderValidator.validateOrderMobileNumber(shortMobileNumber);
	        fail("Expected InValidOrderDetailException but no exception was thrown");
	    } catch (InValidOrderDetailException e) {
	        // Expected exception
	        assertEquals(OrderValidatorErrors.INVALID_MOBILE_NUMBER, e.getMessage());
	    }
	}

	@Test
	public void testValidateOrderPaymentMethodValid() throws InValidOrderDetailException {
	    PaymentMethod validPaymentMethod = PaymentMethod.UPI;
	    assertTrue(OrderValidator.validateOrderPaymentMethod(validPaymentMethod));
	}


}
