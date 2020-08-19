package com.app.movies.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.movies.entity.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long>{

}
