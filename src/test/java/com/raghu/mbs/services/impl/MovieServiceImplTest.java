package com.raghu.mbs.services.impl;

import com.raghu.mbs.entities.Movie;
import com.raghu.mbs.entities.Status;
import com.raghu.mbs.exceptions.MovieDetailsNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class MovieServiceImplTest {

    @Autowired
    private MovieServiceImpl movieService;

    @Autowired
    private StatusServiceImpl statusService;

    private Movie movie;
    /**
     * This class will be used to test the methods of the
     * methods of MovieServiceImpl
     */

    /**
     * Write a method to test acceptMovieDetails
     */

    @Test
    public void testAcceptMovieDetails(){
        //logic to write the test if the method is working as expected
        /**
         * 1.MovieServiceImpl object to test the method
         *
         */

        //Creation of data
        Status status = new Status();
        status.setStatusName("RELEASED");
        statusService.acceptStatusDetails(status);
        movie = new Movie();

        movie.setDuration(150);
        movie.setMovieName("Koi Mil Gya");
        movie.setMovieDescription("Awesome Movie by Alien");
        movie.setTrailerUrl("trailer_url");
        movie.setCoverPhotoUrl("cover_photo_url");
        movie.setReleaseDate(LocalDateTime.of(2021,04,05,03,23));
        movie.setStatus(status);

        //Execution of method
        Movie actualMovieObject = movieService.acceptMovieDetails(movie);

        //If actual is same as expected
        Assertions.assertNotNull(actualMovieObject);
        Assertions.assertEquals(2,actualMovieObject.getMovieId());
    }
    /**
     * Write the test case for getMovieDetails
     *
     * it takes an id, and returns the movie Object
     */
    @Test
    public void testGetMovieDetails() throws MovieDetailsNotFoundException {

        //Setup the data
        //I need to first store something in Database

        //Execution
        Movie savedMovie = movieService.getMovieDetails(2);

        //Assertion
        Assertions.assertNotNull(savedMovie);
    }
}
