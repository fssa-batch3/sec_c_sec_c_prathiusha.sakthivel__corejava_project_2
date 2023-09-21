package com.fssa.greenfarm.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.greenfarm.customerrors.UserValidationErrors;
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

	public static void main(String[] args) throws InvalidUserDetailException {
		System.out.println(UserValidator.validateUserEmailId("prathuisha@gmail.com"));
	}
}

