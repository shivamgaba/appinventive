package com.app.movies.error;

public class InvalidRatingException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5088713502341406923L;

	public InvalidRatingException(String s) {
		super(s);
	}
}
