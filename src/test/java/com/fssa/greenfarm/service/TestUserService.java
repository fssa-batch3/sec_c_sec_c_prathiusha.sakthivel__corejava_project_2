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
	void testUserLoginInvalidInput() {
		UserService userService = new UserService();
		assertThrows(ServiceException.class, () -> { userService.userLogin("hfh", "weakPassword");
		});
	}

	@Test
	void testDeleteUserValidInput() {

		assertDoesNotThrow(() -> userService.deleteUser("prathiusha@gmail.com"));
	}

	@Test
	void testDeleteUserInvalidInput() {

		assertThrows(ServiceException.class, () -> userService.deleteUser("email@gmail.com"));
	}

}
