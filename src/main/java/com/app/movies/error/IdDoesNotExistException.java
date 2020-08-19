package com.app.movies.error;

public class IdDoesNotExistException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5330707666001780031L;

	public IdDoesNotExistException(String s) {
		super(s);
	}
}
