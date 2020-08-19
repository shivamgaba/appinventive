package com.app.movies.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.movies.model.MovieDto;
import com.app.movies.service.MovieService;

@RestController
@RequestMapping("/movie")
public class MovieController {

	private MovieService movieService;

	@Autowired
	public MovieController(MovieService movieService) {
		this.movieService = movieService;
	}
	
	@PostMapping(value="/")
	public void saveMovie(@RequestBody MovieDto movieDto) {
		movieService.saveMovie(movieDto);
	}
	
	@GetMapping(value="/")
	public ResponseEntity<List<MovieDto>> getMovies() {
		List<MovieDto> movie = movieService.getMovies();
		return new ResponseEntity<>(movie, HttpStatus.OK);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<MovieDto> getMovie(@PathVariable(value="id") Long id) {
		MovieDto movieDto = movieService.getMovie(id);
		return new ResponseEntity<>(movieDto, HttpStatus.OK);
	}

	@DeleteMapping(value="/{id}")
	public void deleteMovie(@PathVariable(value="id") Long id) {
		movieService.deleteMovie(id);
	}

	@PatchMapping(value="/{id}")
	public void patchMovie(@PathVariable(value="id") Long id, @RequestBody MovieDto movieDto) {
		movieService.patchMovie(id, movieDto);
	}
}
