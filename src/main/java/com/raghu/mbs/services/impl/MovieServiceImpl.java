package com.raghu.mbs.services.impl;

import com.raghu.mbs.daos.MovieDao;
import com.raghu.mbs.entities.Movie;
import com.raghu.mbs.exceptions.MovieDetailsNotFoundException;
import com.raghu.mbs.services.MovieService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.hibernate.tool.schema.SchemaToolingLogging.LOGGER;


@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieDao movieDao;
    @Override
    public Movie acceptMovieDetails(Movie movie) {
        LOGGER.debug("Movie object passed for creation is : "+movie);
        LOGGER.info("acceptMovieDetails method is triggered");
        return movieDao.save(movie);
    }

    /**
    If correct id passed , return the correct Movie
     else throw the exception-MovieDetailsNotFoundException
     */
    @Override
    public Movie getMovieDetails(int movieId) throws MovieDetailsNotFoundException {
        Movie savedMovie = movieDao.findById(movieId).orElseThrow(()->
                new MovieDetailsNotFoundException("Movie details not found for the movie id: "+movieId));
        return savedMovie;
    }

    @Override
    public Movie updateMovieDetails(int movieId, Movie movie) throws MovieDetailsNotFoundException {
        //First Fetch the saved Movie
        Movie savedMovie = movieDao.findById(movieId).orElseThrow(()->
                new MovieDetailsNotFoundException("Movie details not found for the movie id: "+movieId));
        //Update the saved movie object
        if (movie.getMovieName()!=null){
            savedMovie.setMovieName(movie.getMovieName());
        }
        if (movie.getDuration()>0){
            savedMovie.setDuration(movie.getDuration());
        }
        if (movie.getMovieDescription()!=null){
            savedMovie.setMovieDescription(movie.getMovieDescription());
        }
        if (movie.getCoverPhotoUrl()!=null){
            savedMovie.setCoverPhotoUrl(movie.getCoverPhotoUrl());
        }
        if (movie.getTrailerUrl()!=null){
            savedMovie.setTrailerUrl(movie.getTrailerUrl());
        }
        if (movie.getReleaseDate()!=null){
            savedMovie.setReleaseDate(movie.getReleaseDate());
        }
        if (movie.getStatus()!=null){
            savedMovie.setStatus(movie.getStatus());
        }
        //save it back in the database
        return movieDao.save(savedMovie);
    }

    @Override
    public boolean deleteMovie(int id) {
        movieDao.deleteById(id);
        return true;
    }

    @Override
    public List<Movie> getAllMovieDetails() {
        return movieDao.findAll();
    }
}
