<<<<<<< Updated upstream
package com.fssa.greenfarm.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.greenfarm.customerrors.OrderValidatorErrors;
import com.fssa.greenfarm.customerrors.UserValidationErrors;
import com.fssa.greenfarm.exception.InValidOrderDetailException;
import com.fssa.greenfarm.exception.InvalidUserDetailException;
import com.fssa.greenfarm.model.User;

public class UserValidator {
	public static boolean validateUser(User user) throws InvalidUserDetailException {

		if (user == null) {
			throw new InvalidUserDetailException(UserValidationErrors.INVALID_USER);
		}
		validateUserFirstName(user.getFirstname());
		validateUserEmailId(user.getEmail());
		validateuserPassword(user.getPassword());

		return true;
	}

	public static boolean validateUserId(int user_id) throws InValidOrderDetailException {
		if (user_id <= 0) {
			throw new InValidOrderDetailException(OrderValidatorErrors.INVALID_USER_ID);
		}

		return false;
	}

	private static boolean validateUserFirstName(String firstname) throws InvalidUserDetailException {
		firstname = firstname.trim();

		if (firstname == null) {
			throw new InvalidUserDetailException(UserValidationErrors.INVALID_USER_FIRSTNAME_NULL);
		}

		if (firstname.isEmpty()) {
			throw new InvalidUserDetailException(UserValidationErrors.INVALID_USER_FIRSTNAME_NAME);
		}

		if (firstname.length() < 3) {
			throw new InvalidUserDetailException(UserValidationErrors.INVALID_USER_FIRSTNAME_NAME);
		}

		if (firstname.matches(".*\\d.*")) {
			throw new InvalidUserDetailException(UserValidationErrors.INVALID_USER_FIRSTNAME_NAME);
		}

		if (firstname.matches(".*[^a-zA-Z0-9].*")) {
			throw new InvalidUserDetailException(UserValidationErrors.INVALID_USER_FIRSTNAME_NAME);
		}

		return true;
	}

	public static boolean validateUserEmailId(String email) throws InvalidUserDetailException {
		String emailregex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
		Pattern pattern = Pattern.compile(emailregex);
		Matcher matcher = pattern.matcher(email);
		Boolean isMatch = matcher.matches();
		if (!isMatch) {
			throw new InvalidUserDetailException(UserValidationErrors.INVALID_USER_EMAIL_PATTERN);
		}
		return true;

	}

	public static boolean validateuserPassword(String password) throws InvalidUserDetailException {
		if (password == null) {
			throw new InvalidUserDetailException(UserValidationErrors.INVALID_USER_PASSWORD_NULL);
		}
		// At least one uppercase letter
		Pattern uppercasePattern = Pattern.compile(".*[A-Z].*");

		// At least one lowercase letter
		Pattern lowercasePattern = Pattern.compile(".*[a-z].*");

		// At least one digit
		Pattern digitPattern = Pattern.compile(".*[0-9].*");

		// At least one special character
		Pattern specialCharPattern = Pattern.compile(".*[!@#$%^&*()_+{}\\[\\]:;\"'<>,.?/~].*");

		// No whitespaces
		Pattern noWhitespacePattern = Pattern.compile("\\S*");

		// Match each pattern against the password
		boolean isUppercaseValid = uppercasePattern.matcher(password).matches();
		boolean isLowercaseValid = lowercasePattern.matcher(password).matches();
		boolean isDigitValid = digitPattern.matcher(password).matches();
		boolean isSpecialCharValid = specialCharPattern.matcher(password).matches();
		boolean isNoWhitespaceValid = noWhitespacePattern.matcher(password).matches();

		if (password.isEmpty()) {
			throw new InvalidUserDetailException(UserValidationErrors.INVALID_USER_PASSWORD_PATTERN);
		}

		if (password.length() < 8) {
			throw new InvalidUserDetailException(UserValidationErrors.INVALID_USER_PASSWORD_PATTERN);
		}

		if (!isDigitValid) {
			throw new InvalidUserDetailException(UserValidationErrors.INVALID_USER_PASSWORD_PATTERN);
		}

		if (!isSpecialCharValid) {
			throw new InvalidUserDetailException(UserValidationErrors.INVALID_USER_PASSWORD_PATTERN);
		}

		if (!isUppercaseValid) {
			throw new InvalidUserDetailException(UserValidationErrors.INVALID_USER_PASSWORD_PATTERN);
		}

		if (!isLowercaseValid) {
			throw new InvalidUserDetailException(UserValidationErrors.INVALID_USER_PASSWORD_PATTERN);
		}

		if (!isNoWhitespaceValid) {
			throw new InvalidUserDetailException(UserValidationErrors.INVALID_USER_PASSWORD_PATTERN);
		}

		return true;

	}

	public static void validateUserCity(String city) throws InvalidUserDetailException {
		if (city == null || "".equals(city.trim()) || city.length() < 2) {
			throw new InvalidUserDetailException(UserValidationErrors.INVALID_USER_CITYNAME);
		}
	}

	public static void validateOrderState(String state) throws InvalidUserDetailException {
		if (state == null || "".equals(state.trim()) || state.length() < 2) {
			throw new InvalidUserDetailException(UserValidationErrors.INVALID_USER_STATENAME);
		}
	}

	public static boolean validateUserAddress(String address) throws InvalidUserDetailException {
		if (address == null || "".equals(address.trim())) {
			throw new InvalidUserDetailException(UserValidationErrors.INVALID_USER_ADDRESS);
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

	public static boolean validateUserrPincode(int pincode) throws InvalidUserDetailException {
		String pincodeStr = String.valueOf(pincode);

		if (pincodeStr.length() == 7 && pincodeStr.matches("\\d+")) {
			return true; // valid pincode
		} else {
			throw new InvalidUserDetailException(UserValidationErrors.INVALID_PINCODE);
		}
	}

	public static boolean validateUserMobileNumber(long mobile_number) throws InvalidUserDetailException {
		String mobileNumberStr = String.valueOf(mobile_number);

		if (mobileNumberStr.length() == 10 && mobileNumberStr.matches("\\d+")) {
			return true; // Valid mobile number
		} else {
			throw new InvalidUserDetailException(UserValidationErrors.INVALID_MOBILE_NUMBER);
		}

	}

public boolean validateAddressDetails(User user) throws InvalidUserDetailException {
		
		if(user == null) {
			throw new InvalidUserDetailException(UserValidationErrors.INVALID_USER);
		}
		
		validateUserCity(user.getCity());
		
		validateUserAddress(user.getAddress());
		
		validateOrderState(user.getState());
		
		validateUserrPincode(user.getPincode());
		
		validateUserMobileNumber(user.getMobilenumber());
		
		return true;
		
	}

}
=======
package com.fssa.greenfarm.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.greenfarm.customerrors.OrderValidatorErrors;
import com.fssa.greenfarm.customerrors.UserValidationErrors;
import com.fssa.greenfarm.exception.InValidOrderDetailException;
import com.fssa.greenfarm.exception.InvalidUserDetailException;
import com.fssa.greenfarm.model.User;

public class UserValidator {
	public static boolean validateUser(User user) throws InvalidUserDetailException {

		if (user == null) {
			throw new InvalidUserDetailException(UserValidationErrors.INVALID_USER);
		}
		validateUserFirstName(user.getFirstname());
		validateUserEmailId(user.getEmail());
		validateuserPassword(user.getPassword());

		return true;
	}

	public static boolean validateUserId(int user_id) throws InValidOrderDetailException {
		if (user_id <= 0) {
			throw new InValidOrderDetailException(OrderValidatorErrors.INVALID_USER_ID);
		}

		return false;
	}

	private static boolean validateUserFirstName(String firstname) throws InvalidUserDetailException {
		firstname = firstname.trim();

		if (firstname == null) {
			throw new InvalidUserDetailException(UserValidationErrors.INVALID_USER_FIRSTNAME_NULL);
		}

		if (firstname.isEmpty()) {
			throw new InvalidUserDetailException(UserValidationErrors.INVALID_USER_FIRSTNAME_NAME);
		}

		if (firstname.length() < 3) {
			throw new InvalidUserDetailException(UserValidationErrors.INVALID_USER_FIRSTNAME_NAME);
		}

		if (firstname.matches(".*\\d.*")) {
			throw new InvalidUserDetailException(UserValidationErrors.INVALID_USER_FIRSTNAME_NAME);
		}

		if (firstname.matches(".*[^a-zA-Z0-9].*")) {
			throw new InvalidUserDetailException(UserValidationErrors.INVALID_USER_FIRSTNAME_NAME);
		}

		return true;
	}

	public static boolean validateUserEmailId(String email) throws InvalidUserDetailException {
		String emailregex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
		Pattern pattern = Pattern.compile(emailregex);
		Matcher matcher = pattern.matcher(email);
		Boolean isMatch = matcher.matches();
		if (!isMatch) {
			throw new InvalidUserDetailException(UserValidationErrors.INVALID_USER_EMAIL_PATTERN);
		}
		return true;

	}

	public static boolean validateuserPassword(String password) throws InvalidUserDetailException {
		if (password == null) {
			throw new InvalidUserDetailException(UserValidationErrors.INVALID_USER_PASSWORD_NULL);
		}
		// At least one uppercase letter
		Pattern uppercasePattern = Pattern.compile(".*[A-Z].*");

		// At least one lowercase letter
		Pattern lowercasePattern = Pattern.compile(".*[a-z].*");

		// At least one digit
		Pattern digitPattern = Pattern.compile(".*[0-9].*");

		// At least one special character
		Pattern specialCharPattern = Pattern.compile(".*[!@#$%^&*()_+{}\\[\\]:;\"'<>,.?/~].*");

		// No whitespaces
		Pattern noWhitespacePattern = Pattern.compile("\\S*");

		// Match each pattern against the password
		boolean isUppercaseValid = uppercasePattern.matcher(password).matches();
		boolean isLowercaseValid = lowercasePattern.matcher(password).matches();
		boolean isDigitValid = digitPattern.matcher(password).matches();
		boolean isSpecialCharValid = specialCharPattern.matcher(password).matches();
		boolean isNoWhitespaceValid = noWhitespacePattern.matcher(password).matches();

		if (password.isEmpty()) {
			throw new InvalidUserDetailException(UserValidationErrors.INVALID_USER_PASSWORD_PATTERN);
		}

		if (password.length() < 8) {
			throw new InvalidUserDetailException(UserValidationErrors.INVALID_USER_PASSWORD_PATTERN);
		}

		if (!isDigitValid) {
			throw new InvalidUserDetailException(UserValidationErrors.INVALID_USER_PASSWORD_PATTERN);
		}

		if (!isSpecialCharValid) {
			throw new InvalidUserDetailException(UserValidationErrors.INVALID_USER_PASSWORD_PATTERN);
		}

		if (!isUppercaseValid) {
			throw new InvalidUserDetailException(UserValidationErrors.INVALID_USER_PASSWORD_PATTERN);
		}

		if (!isLowercaseValid) {
			throw new InvalidUserDetailException(UserValidationErrors.INVALID_USER_PASSWORD_PATTERN);
		}

		if (!isNoWhitespaceValid) {
			throw new InvalidUserDetailException(UserValidationErrors.INVALID_USER_PASSWORD_PATTERN);
		}

		return true;

	}

	public static void validateUserCity(String city) throws InvalidUserDetailException {
		if (city == null || "".equals(city.trim()) || city.length() < 2) {
			throw new InvalidUserDetailException(UserValidationErrors.INVALID_USER_CITYNAME);
		}
	}

	public static void validateOrderState(String state) throws InvalidUserDetailException {
		if (state == null || "".equals(state.trim()) || state.length() < 2) {
			throw new InvalidUserDetailException(UserValidationErrors.INVALID_USER_STATENAME);
		}
	}

	public static boolean validateUserAddress(String address) throws InvalidUserDetailException {
		if (address == null || "".equals(address.trim())) {
			throw new InvalidUserDetailException(UserValidationErrors.INVALID_USER_ADDRESS);
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

	public static boolean validateUserrPincode(int pincode) throws InvalidUserDetailException {
		String pincodeStr = String.valueOf(pincode);

		if (pincodeStr.length() == 7 && pincodeStr.matches("\\d+")) {
			return true; // valid pincode
		} else {
			throw new InvalidUserDetailException(UserValidationErrors.INVALID_PINCODE);
		}
	}

	public static boolean validateUserMobileNumber(long mobile_number) throws InvalidUserDetailException {
		String mobileNumberStr = String.valueOf(mobile_number);

		if (mobileNumberStr.length() == 10 && mobileNumberStr.matches("\\d+")) {
			return true; // Valid mobile number
		} else {
			throw new InvalidUserDetailException(UserValidationErrors.INVALID_MOBILE_NUMBER);
		}

	}

public boolean validateAddressDetails(User user) throws InvalidUserDetailException {
		
		if(user == null) {
			throw new InvalidUserDetailException(UserValidationErrors.INVALID_USER);
		}
		
		validateUserCity(user.getCity());
		
		validateUserAddress(user.getAddress());
		
		validateOrderState(user.getState());
		
		validateUserrPincode(user.getPincode());
		
		validateUserMobileNumber(user.getMobilenumber());
		
		return true;
		
	}

}
>>>>>>> Stashed changes
