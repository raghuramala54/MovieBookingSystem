package com.raghu.mbs.services.impl;

import com.raghu.mbs.daos.MovieTheatreDao;
import com.raghu.mbs.entities.MovieTheatre;
import com.raghu.mbs.exceptions.MovieDetailsNotFoundException;
import com.raghu.mbs.exceptions.MovieTheatreDetailsNotFoundException;
import com.raghu.mbs.exceptions.TheatreDetailsNotFoundException;
import com.raghu.mbs.services.MovieService;
import com.raghu.mbs.services.MovieTheatreService;
import com.raghu.mbs.services.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieTheatreServiceImpl implements MovieTheatreService {
    @Autowired
    private MovieTheatreDao movieTheatreDao;

    @Autowired
    private TheatreService theatreService;

    @Autowired
    private MovieService movieService;

    @Override
    public MovieTheatre acceptMovieTheatreDetails(MovieTheatre movieTheatre)
            throws MovieDetailsNotFoundException, TheatreDetailsNotFoundException {
        movieService.getMovieDetails(movieTheatre.getMovie().getMovieId());
        theatreService.getTheatreDetails(movieTheatre.getTheatre().getTheatreId());
        return movieTheatreDao.save(movieTheatre);
    }

    @Override
    public MovieTheatre getMovieTheatreDetails(int id) throws MovieTheatreDetailsNotFoundException {
        return movieTheatreDao.findById(id)
                .orElseThrow(
                        () -> new MovieTheatreDetailsNotFoundException("MovieTheatre not found by id: " + id)
                );
    }

    @Override
    public boolean deleteMovieTheatre(int id) throws MovieTheatreDetailsNotFoundException {
        MovieTheatre movieTheatre = getMovieTheatreDetails(id);
        movieTheatreDao.delete(movieTheatre);
        return true;
    }

    @Override
    public List<MovieTheatre> getAllMovieTheatreDetails() {
        return movieTheatreDao.findAll();
    }
}
