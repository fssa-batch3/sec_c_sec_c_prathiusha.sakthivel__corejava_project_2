package com.fssa.greenfarm.exception;

public class InvalidUserDetailException extends Exception {
	private static final long serialVersionUID = -8105491977357554060L;

	/**
	 *  Calling each super constructors for each of the types
	 */

	public InvalidUserDetailException(String msg) {
		super(msg);
	}

}
