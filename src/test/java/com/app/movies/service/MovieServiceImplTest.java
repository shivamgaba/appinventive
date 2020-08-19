package com.app.movies.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.app.movies.entity.Movie;
import com.app.movies.error.IdDoesNotExistException;
import com.app.movies.error.InvalidRatingException;
import com.app.movies.model.MovieDto;
import com.app.movies.model.MovieDto.MovieDtoBuilder;
import com.app.movies.repository.MovieRepository;

public class MovieServiceImplTest {

	@InjectMocks
	MovieServiceImpl movieServiceImpl;

	@Mock
	private MovieRepository repo;

	@Rule
	public final ExpectedException exception = ExpectedException.none();

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void shouldsaveMovie() {
		movieServiceImpl.saveMovie(buildMovieDto());
	}

	@Test
	public void shouldNotsaveMovie() {
		MovieDto.MovieDtoBuilder movieDtoBuilder = new MovieDtoBuilder();
		movieDtoBuilder.setId(1L);
		movieDtoBuilder.setTitle("race");
		movieDtoBuilder.setCategory("thriller");
		movieDtoBuilder.setRating(0.4D);
		exception.expect(InvalidRatingException.class);
		movieServiceImpl.saveMovie(movieDtoBuilder.build());
	}

	@Test
	public void shouldgetMovies() {
		List<Movie> list = new ArrayList<>();
		list.add(buildMovie().get());
		Mockito.when(repo.findAll()).thenReturn(list);
		movieServiceImpl.getMovies();
	}

	@Test
	public void shouldgetMovie() {
		Mockito.when(repo.findById(Mockito.anyLong())).thenReturn(buildMovie());
		movieServiceImpl.getMovie(1L);
	}

	@Test
	public void shouldNotgetMovie() {
		exception.expect(IdDoesNotExistException.class);
		movieServiceImpl.getMovie(1L);
	}

	@Test
	public void shoulddeleteMovie() {
		Mockito.when(repo.findById(Mockito.anyLong())).thenReturn(buildMovie());
		movieServiceImpl.deleteMovie(1L);
	}

	@Test
	public void shouldNotdeleteMovie() {
		exception.expect(IdDoesNotExistException.class);
		movieServiceImpl.deleteMovie(1L);
	}

	@Test
	public void shouldpatchMovie() {
		Mockito.when(repo.findById(Mockito.anyLong())).thenReturn(buildMovie());
		movieServiceImpl.patchMovie(1L, buildMovieDto());
	}

	@Test
	public void shouldNotpatchMovie() {
		exception.expect(IdDoesNotExistException.class);
		movieServiceImpl.patchMovie(1L, buildMovieDto());
	}

	private MovieDto buildMovieDto() {
		MovieDto.MovieDtoBuilder movieDtoBuilder = new MovieDtoBuilder();
		movieDtoBuilder.setId(1L);
		movieDtoBuilder.setTitle("race");
		movieDtoBuilder.setCategory("thriller");
		movieDtoBuilder.setRating(2.5D);
		return movieDtoBuilder.build();
	}
	
	private Optional<Movie> buildMovie() {
		Movie movie = new Movie();
		movie.setId(1L);
		movie.setTitle("race");
		movie.setCategory("comedy");
		movie.setRating(2.5D);
		return Optional.of(movie);
	}
}
