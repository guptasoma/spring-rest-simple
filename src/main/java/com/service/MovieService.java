package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.model.Movie;

@Service
public class MovieService {
	private final List<Movie> movieList = new ArrayList<>();

    public MovieService() {
        // Adding some sample movies
        movieList.add(new Movie("1", "Inception", 2010));
        movieList.add(new Movie("2", "Interstellar", 2014));
        movieList.add(new Movie("3", "Parasite", 2019));
    }

    // Get all movies
    public List<Movie> getAllMovies() {
    	return movieList;
    }
    
    // Get movie by ID
    public Movie getMovieById(String id) {
    	Optional<Movie> opt=movieList.stream()
    			.filter((m)->m.getId().equals(id))
    			.findFirst();
    	return opt.get();
    }
    
    // Update a movie
    public Movie updateMovie(String id, Movie updatedMovie) {
        Optional<Movie> existingMovie = movieList.stream()
                .filter(movie -> movie.getId().equals(id))
                .findFirst();

         existingMovie.map(movie -> {
            movie.setTitle(updatedMovie.getTitle());
            movie.setReleaseYear(updatedMovie.getReleaseYear());
            return movie;
        });         
        return existingMovie.get();
    }
    
    
    // Add a new movie
    public Movie addMovie(Movie movie) {
        movieList.add(movie);
        return movie;
    }
    
    
    // Delete a movie
    public boolean deleteMovie(String id) {
        return movieList.removeIf(movie -> movie.getId().equals(id));       
    }

    
}
