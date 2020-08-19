package com.app.movies.service;

import java.util.List;

import com.app.movies.model.MovieDto;

public interface MovieService {

	public void saveMovie(MovieDto movieDto);
	
	public List<MovieDto> getMovies();
	
	public MovieDto getMovie(Long id);
	
	public void deleteMovie(Long id);
	
	public void patchMovie(Long id, MovieDto movieDto);
}
