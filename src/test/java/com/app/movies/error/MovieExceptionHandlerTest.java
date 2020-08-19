package com.app.movies.error;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

public class MovieExceptionHandlerTest {

	@InjectMocks
	MovieExceptionHandler movieExceptionHandler;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void shoulderrorHandlerInvalidRating() {
		movieExceptionHandler.errorHandlerInvalidRating(new InvalidRatingException("invalid rating exception"));
	}

	@Test
	public void shoulderrorHandlerInvalidId() {
		movieExceptionHandler.errorHandlerInvalidId(new IdDoesNotExistException("id does not exist exception"));
	}
}
