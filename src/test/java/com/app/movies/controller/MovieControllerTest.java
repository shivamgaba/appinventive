package com.app.movies.controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.app.movies.model.MovieDto;
import com.app.movies.model.MovieDto.MovieDtoBuilder;
import com.app.movies.service.MovieService;

public class MovieControllerTest {

	@InjectMocks
	MovieController movieController;

	@Mock
	private MovieService movieService;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void shouldsaveMovie() {
		movieController.saveMovie(buildMovieDto());
	}

	@Test
	public void shouldgetMovies() {
		movieController.getMovies();
	}

	@Test
	public void shouldgetMovie() {
		movieController.getMovie(1L);
	}

	@Test
	public void shoulddeleteMovie() {
		movieController.deleteMovie(1L);
	}

	@Test
	public void shouldpatchMovie() {
		movieController.patchMovie(1L, buildMovieDto());
	}

	private MovieDto buildMovieDto() {
		MovieDto.MovieDtoBuilder movieDtoBuilder = new MovieDtoBuilder();
		movieDtoBuilder.setId(1L);
		movieDtoBuilder.setTitle("race");
		movieDtoBuilder.setCategory("thriller");
		movieDtoBuilder.setRating(2.5D);
		return movieDtoBuilder.build();
	}
}
