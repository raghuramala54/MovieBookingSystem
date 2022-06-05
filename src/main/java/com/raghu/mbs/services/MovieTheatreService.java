package com.raghu.mbs.services;
import com.raghu.mbs.entities.MovieTheatre;
import com.raghu.mbs.exceptions.MovieDetailsNotFoundException;
import com.raghu.mbs.exceptions.MovieTheatreDetailsNotFoundException;
import com.raghu.mbs.exceptions.TheatreDetailsNotFoundException;

import java.util.List;

public interface MovieTheatreService {
    public MovieTheatre acceptMovieTheatreDetails(MovieTheatre movieTheatre) throws MovieDetailsNotFoundException,
            TheatreDetailsNotFoundException;
    public MovieTheatre getMovieTheatreDetails(int id) throws MovieTheatreDetailsNotFoundException;
    public boolean deleteMovieTheatre(int id) throws MovieTheatreDetailsNotFoundException;
    public List<MovieTheatre> getAllMovieTheatreDetails();
}
