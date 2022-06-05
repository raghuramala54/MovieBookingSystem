package com.raghu.mbs.controllers;

import com.raghu.mbs.dtos.MovieDTO;
import com.raghu.mbs.entities.Movie;
import com.raghu.mbs.entities.Status;
import com.raghu.mbs.exceptions.InvalidMovieRequestBodyException;
import com.raghu.mbs.exceptions.MovieDetailsNotFoundException;
import com.raghu.mbs.exceptions.StatusDetailsNotFoundException;
import com.raghu.mbs.services.MovieService;
import com.raghu.mbs.services.StatusService;
import com.raghu.mbs.validators.MovieDTOValidators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @Autowired
    private StatusService statusService;

    /**
     * I want to create a new movie
     * new movie created will be saved to the db
     *
     * post-127.0.0.1:8081/mbs/v1/movies
     *
     * JSON request body{} ---> MovieDTO
     */
    @PostMapping
    public ResponseEntity createMovie(@RequestBody MovieDTO movieDTO) throws StatusDetailsNotFoundException, InvalidMovieRequestBodyException {
        /**
         * Save the movieDTO into db
         *
         * 0.Create MovieEntity from MovieDTO
         * 1.Use MovieService to save it
         */
        MovieDTOValidators.isValid(movieDTO);
        Movie movieEntity = convertMovieDTOtoEntity(movieDTO);
        Movie savedMovieEntity = movieService.acceptMovieDetails(movieEntity);
        MovieDTO responseBody = convertMovieEntitytoDTO(savedMovieEntity);
        return new ResponseEntity(responseBody,HttpStatus.CREATED);
    }

    private MovieDTO convertMovieEntitytoDTO(Movie savedMovieEntity) {
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setDuration(savedMovieEntity.getDuration());
        movieDTO.setMovieId(savedMovieEntity.getMovieId());
        movieDTO.setMovieDescription(savedMovieEntity.getMovieDescription());
        movieDTO.setSatusId(savedMovieEntity.getStatus().getStatusId());
        movieDTO.setCoverPhotoUrl(savedMovieEntity.getCoverPhotoUrl());
        movieDTO.setTrailerUrl(savedMovieEntity.getTrailerUrl());
        movieDTO.setMovieName(savedMovieEntity.getMovieName());
        movieDTO.setReleaseDate(savedMovieEntity.getReleaseDate());
        return movieDTO;
    }

    private Movie convertMovieDTOtoEntity(MovieDTO movieDTO) throws StatusDetailsNotFoundException {

        Movie movie = new Movie();
        movie.setMovieId(movieDTO.getMovieId());
        movie.setMovieName(movieDTO.getMovieName());
        movie.setMovieDescription(movieDTO.getMovieDescription());
        movie.setReleaseDate(movieDTO.getReleaseDate());
        movie.setTrailerUrl(movieDTO.getTrailerUrl());
        movie.setCoverPhotoUrl(movieDTO.getCoverPhotoUrl());

        /**
         * Set the status of the movie
         */
        int statusId = movieDTO.getSatusId();
        Status status = statusService.getStatusBasedOnId(statusId);
        movie.setStatus(status);

        return movie;
    }

    /**
     * Get all the movies created so far
     */
    @GetMapping
    public ResponseEntity getAllMovies(){
        List<Movie> movieList = movieService.getAllMovieDetails();
        List<MovieDTO> movieDTOList = new ArrayList<>();

        for (Movie movie: movieList){
            MovieDTO movieDTO = convertMovieEntitytoDTO(movie);
            movieDTOList.add(movieDTO);
        }
        return new ResponseEntity<>(movieDTOList,HttpStatus.OK);
    }

    @GetMapping("/{movieId}")
    public ResponseEntity getMovieBasedOnId(
            @PathVariable(name = "movieId") int movieId) throws MovieDetailsNotFoundException{


        Movie movie = movieService.getMovieDetails(movieId);
        /**
         * In order to provide the better message to the client the request better
         */

        /**
         * Convert the Movie object to MovieDTO object
         */
        MovieDTO movieDTO = convertMovieEntitytoDTO(movie);

        /**
         * I should not use, Movie class to return the response to the client
         */
        return new ResponseEntity(movieDTO,HttpStatus.OK);

    }
}
