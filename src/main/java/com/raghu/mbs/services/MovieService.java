package com.raghu.mbs.services;

import com.raghu.mbs.entities.Movie;
import com.raghu.mbs.exceptions.MovieDetailsNotFoundException;

import java.util.List;

public interface MovieService {
    public Movie acceptMovieDetails(Movie movie);
    public Movie getMovieDetails(int movieId) throws MovieDetailsNotFoundException;
    public Movie updateMovieDetails(int movieId,Movie movie) throws MovieDetailsNotFoundException;
    public boolean deleteMovie(int id);
    public List<Movie> getAllMovieDetails();
}
