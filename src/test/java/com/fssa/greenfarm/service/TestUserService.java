<<<<<<< Updated upstream
package com.fssa.greenfarm.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.sql.SQLException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.greenfarm.exception.DAOException;
import com.fssa.greenfarm.exception.InvalidUserDetailException;
import com.fssa.greenfarm.model.User;
import com.google.protobuf.ServiceException;

public class TestUserService {
	UserService userService = new UserService();

	private User getUser() {
		User user = new User();
		user.getFirstname();
		long nanoTime = System.nanoTime();
		user.getEmail();
		user.setPassword("TestP@123");

		return user;
	}

	@Test
	void testValidUserSignUp() {
		User user = getUser();
		user.setFirstname("Prathiusha");
		user.setLastname("sakthivel");
		user.setEmail("prathiusha@gmail.com");
		user.setPassword("Prathiusha@22");
		assertDoesNotThrow(() -> userService.userSignUp(user));
	}

	@Test
	void testUserSignUpInvalidUserFirstName() {
		User user = getUser();
		user.setFirstname("Pr");
		assertThrows(ServiceException.class, () -> userService.userSignUp(user));
	}

	@Test
	void testValidUserLogin() throws ServiceException, InvalidUserDetailException, DAOException, SQLException {

		Assertions.assertTrue(userService.userLogin("prathiusha@gmail.com", "Prathiusha@22"));
	}



	@Test
	void testDeleteUserValidInput() {

		assertDoesNotThrow(() -> userService.deleteUser("prathiusha@gmail.com"));
	}

	@Test
	void testDeleteUserInvalidInput() {

		assertThrows(ServiceException.class, () -> userService.deleteUser("email@gmail.com"));
	}

	@Test
	void testValidUserDetails() {
		User user = getUser();
		user.setEmail("swetha@gmail.com");
		user.setAddress("14th cross");
		user.setCity("chennai");
		user.setState("tamilnadu");
		user.setPincode(123456);
		user.setMobilenumber(1234567890);
		assertDoesNotThrow(() -> userService.updateUserDetails(user));
	}
	
}
=======
package com.fssa.greenfarm.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.sql.SQLException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.greenfarm.exception.DAOException;
import com.fssa.greenfarm.exception.InvalidUserDetailException;
import com.fssa.greenfarm.model.User;
import com.google.protobuf.ServiceException;

public class TestUserService {
	UserService userService = new UserService();

	private User getUser() {
		User user = new User();
		user.getFirstname();
		long nanoTime = System.nanoTime();
		user.getEmail();
		user.setPassword("TestP@123");

		return user;
	}

	@Test
	void testValidUserSignUp() {
		User user = getUser();
		user.setFirstname("Prathiusha");
		user.setLastname("sakthivel");
		user.setEmail("prathiusha@gmail.com");
		user.setPassword("Prathiusha@22");
		assertDoesNotThrow(() -> userService.userSignUp(user));
	}

	@Test
	void testUserSignUpInvalidUserFirstName() {
		User user = getUser();
		user.setFirstname("Pr");
		assertThrows(ServiceException.class, () -> userService.userSignUp(user));
	}

	@Test
	void testValidUserLogin() throws ServiceException, InvalidUserDetailException, DAOException, SQLException {

		Assertions.assertTrue(userService.userLogin("prathiusha@gmail.com", "Prathiusha@22"));
	}



	@Test
	void testDeleteUserValidInput() {

		assertDoesNotThrow(() -> userService.deleteUser("prathiusha@gmail.com"));
	}

	@Test
	void testDeleteUserInvalidInput() {

		assertThrows(ServiceException.class, () -> userService.deleteUser("email@gmail.com"));
	}

	@Test
	void testValidUserDetails() {
		User user = getUser();
		user.setEmail("swetha@gmail.com");
		user.setAddress("14th cross");
		user.setCity("chennai");
		user.setState("tamilnadu");
		user.setPincode(123456);
		user.setMobilenumber(1234567890);
		assertDoesNotThrow(() -> userService.updateUserDetails(user));
	}
	
}
>>>>>>> Stashed changes
