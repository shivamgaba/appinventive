package com.app.movies.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MovieExceptionHandler {

	@ExceptionHandler(InvalidRatingException.class)
	public ResponseEntity<?> errorHandlerInvalidRating(InvalidRatingException e) {
		return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(IdDoesNotExistException.class)
	public ResponseEntity<?> errorHandlerInvalidId(IdDoesNotExistException e) {
		return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}
}
