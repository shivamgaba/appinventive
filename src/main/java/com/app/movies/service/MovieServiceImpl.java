package com.app.movies.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.movies.entity.Movie;
import com.app.movies.error.IdDoesNotExistException;
import com.app.movies.error.InvalidRatingException;
import com.app.movies.model.MovieDto;
import com.app.movies.model.MovieDto.MovieDtoBuilder;
import com.app.movies.repository.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService{

	
	private MovieRepository repo;
	
	@Autowired
	public MovieServiceImpl(MovieRepository repo) {
		this.repo = repo;
	}
	
	public void saveMovie(MovieDto movieDto) {
		Movie movie = new Movie();
		
		movie.setId(movieDto.getId());
		movie.setTitle(movieDto.getTitle());
		movie.setCategory(movieDto.getCategory());
		if(movieDto.getRating() >= 0.5 && movieDto.getRating() <= 5) {
		movie.setRating(movieDto.getRating());
		} else {
			throw new InvalidRatingException("invalid rating exception");
		}
		repo.save(movie);
	}
	
	public List<MovieDto> getMovies() {
		List<Movie> movieList = repo.findAll();
		List<MovieDto> dtoList = new ArrayList<>();
		
		for(Movie movie : movieList) {
			MovieDto.MovieDtoBuilder movieDtoBuilder = new MovieDtoBuilder();
			movieDtoBuilder.setId(movie.getId());
			movieDtoBuilder.setTitle(movie.getTitle());
			movieDtoBuilder.setCategory(movie.getCategory());
			movieDtoBuilder.setRating(movie.getRating());
			dtoList.add(movieDtoBuilder.build());
		}
		return dtoList;
	}
	
	public MovieDto getMovie(Long id) {
		Optional<Movie> movie = repo.findById(id);
		if(movie.isPresent()) {
			MovieDto.MovieDtoBuilder movieDtoBuilder = new MovieDtoBuilder();
			movieDtoBuilder.setId(movie.get().getId());
			movieDtoBuilder.setTitle(movie.get().getTitle());
			movieDtoBuilder.setCategory(movie.get().getCategory());
			movieDtoBuilder.setRating(movie.get().getRating());
			return movieDtoBuilder.build();
		} else {
			throw new IdDoesNotExistException("id does not exist exception");
		}
	}
	
	public void deleteMovie(Long id) {
		Optional<Movie> movie = repo.findById(id);
		if(movie.isPresent()) {
			repo.delete(movie.get());
		} else {
			throw new IdDoesNotExistException("id does not exist exception"); 
		}
	}

	@Override
	public void patchMovie(Long id, MovieDto movieDto) {
		Optional<Movie> movie = repo.findById(id);
		if(movie.isPresent()) {
			Optional.ofNullable(movieDto).map(o-> o.getId()).ifPresent(movie.get()::setId);
			Optional.ofNullable(movieDto).map(o->o.getTitle()).ifPresent(movie.get()::setTitle);
			Optional.ofNullable(movieDto).map(o->o.getCategory()).ifPresent(movie.get()::setCategory);
			Optional.ofNullable(movieDto).map(o->o.getRating()).ifPresent(movie.get()::setRating);
			repo.saveAndFlush(movie.get());
		} else {
			throw new IdDoesNotExistException("id does not exist exception");
		}
	}
}
