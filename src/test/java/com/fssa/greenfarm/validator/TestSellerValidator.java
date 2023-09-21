package com.fssa.greenfarm.validator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.greenfarm.customerrors.SellerValidatorErrors;
import com.fssa.greenfarm.exception.InvalidUserDetailException;
import com.fssa.greenfarm.exception.SellerInvalidException;

public class TestSellerValidator {

	@Test
	void testValidateValidSeller() {
		try {
			assertTrue(SellerValidator.validateName("John Doe"));
		} catch (SellerInvalidException e) {

			fail("Exception should not have been thrown for valid seller");
		}
	}

	@Test
	void testValidateNullSeller() {
		try {
			SellerValidator.validateName(null);
			fail("Exception should have been thrown for null seller");
		} catch (SellerInvalidException e) {
			assertEquals(SellerValidatorErrors.INVALID_NAME, e.getMessage());
		}
	}

	@Test
	void testValidateInvalidName() {
		try {
			SellerValidator.validateName("J");
			fail("Exception should have been thrown for invalid name");
		} catch (SellerInvalidException e) {
			assertEquals(SellerValidatorErrors.INVALID_NAME, e.getMessage());
		}
	}


	@Test
	public void testValidateValidFarmImage() {

		
		
		assertThrows(SellerInvalidException.class, () -> SellerValidator.validateFarmImage("\".jpg\""));

	}

	@Test
	void testValidateInvalidFarmImage() {
		
		
		assertThrows(SellerInvalidException.class, () -> SellerValidator.validateFarmImage(""));

	}

	@Test
	void testValidateInvalidFeedback() {
		
		
		assertThrows(SellerInvalidException.class, () -> SellerValidator.validateFeedback(""));


	}

	@Test
	void testValidateInvalidEmail() throws SellerInvalidException {

		assertThrows(SellerInvalidException.class, () -> SellerValidator.validateEmail("prathiushagmail.com"));

	}

	@Test
	void testValidateInvalidAddress() {
		try {
			SellerValidator.validateAddress(" ");
			fail("Exception should have been thrown for invalid address");
		} catch (SellerInvalidException e) {
			assertEquals(SellerValidatorErrors.INVALID_ADDRESS, e.getMessage());
		}
	}

	@Test
	void testValidateInvalidDistrict() {
		try {
			SellerValidator.validateDistrict("D");
			fail("Exception should have been thrown for invalid district");
		} catch (SellerInvalidException e) {
			assertEquals(SellerValidatorErrors.INVALID_DISTRICT, e.getMessage());
		}
	}

	@Test
	void testValidateInvalidState() {
		try {
			SellerValidator.validateState(null);
			fail("Exception should have been thrown for invalid state");
		} catch (SellerInvalidException e) {
			assertEquals(SellerValidatorErrors.INVALID_STATE, e.getMessage());
		}
	}

	@Test
	void testValidateInvalidBankname() {
		try {
			SellerValidator.validateBankname("b");
			fail("Exception should have been thrown for invalid bankname");
		} catch (SellerInvalidException e) {
			assertEquals(SellerValidatorErrors.INVALID_BANKNAME, e.getMessage());
		}
	}

	@Test
	void testValidateInvalidBranchName() {
		try {
			SellerValidator.validateBranchName(" ");
			fail("Exception should have been thrown for invalid branchname");
		} catch (SellerInvalidException e) {
			assertEquals(SellerValidatorErrors.INVALID_BRANCHNAME, e.getMessage());
		}
	}

}
