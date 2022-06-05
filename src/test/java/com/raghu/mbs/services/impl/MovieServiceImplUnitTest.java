package com.raghu.mbs.services.impl;

import com.raghu.mbs.daos.MovieDao;
import com.raghu.mbs.entities.Movie;
import com.raghu.mbs.entities.Status;
import com.raghu.mbs.exceptions.MovieDetailsNotFoundException;
import com.raghu.mbs.services.StatusService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Optional;

@SpringBootTest
public class MovieServiceImplUnitTest {
    @Mock  /** This will create a mocked moviedao **/
    private MovieDao movieDao;

    /**
     * I need to create a movieServiceOject which uses mocked MovieDao
     */

    @InjectMocks
    private MovieServiceImpl movieService;

    @Autowired
    private StatusServiceImpl statusService;

    private Movie movie;

    private Movie savedMovie;

    @BeforeEach
    public void beforeEach(){
        movie = new Movie();
        movie.setDuration(150);
        movie.setMovieName("Koi Mil Gya");
        movie.setMovieDescription("Awesome Movie by Alien");
        movie.setTrailerUrl("trailer_url");
        movie.setCoverPhotoUrl("cover_photo_url");
        movie.setReleaseDate(LocalDateTime.of(2021,04,05,03,23));

        savedMovie = new Movie();
        savedMovie.setMovieId(1);
        savedMovie.setDuration(150);
        savedMovie.setMovieName("Koi Mil Gya");
        savedMovie.setMovieDescription("Awesome Movie by Alien");
        savedMovie.setTrailerUrl("trailer_url");
        savedMovie.setCoverPhotoUrl("cover_photo_url");
        savedMovie.setReleaseDate(LocalDateTime.of(2021,04,05,03,23));
    }

    /**
     * Test the method acceptmoviedetails
     */
    @Test
    public void testAcceptMovieDetails(){
        /** Logic for testing **/

        //We need to create the data --in the beforeEach method

        //Define the behaviour of movieDao
        Mockito.when(movieDao.save(movie)).thenReturn(savedMovie);
        //We need to execute the method
        Movie savedMovie = movieService.acceptMovieDetails(movie);

        //we need to check if the method returned the correct result
        Assertions.assertNotNull(savedMovie);
        Assertions.assertEquals(1,savedMovie.getMovieId());
    }
    /**
     * Write the test case for getMovieDetails
     *
     * it takes an id and returns the movie object
     */
    @Test
    public void testGetMovieDetails() throws MovieDetailsNotFoundException {
        /** Setup the data :need to 1st store something in Database*/

        /** Define the behaviour for mock **/
        Mockito.when(movieDao.findById(1)).thenReturn(Optional.of(savedMovie));

        /** Execution **/
        Movie savedMovie = movieService.getMovieDetails(1);

        /** Assertion **/
        Assertions.assertNotNull(savedMovie);
    }

}
