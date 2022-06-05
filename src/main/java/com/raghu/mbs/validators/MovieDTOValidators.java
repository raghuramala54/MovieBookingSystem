package com.raghu.mbs.validators;

import com.raghu.mbs.dtos.MovieDTO;
import com.raghu.mbs.exceptions.InvalidMovieRequestBodyException;

public class MovieDTOValidators {
    public static boolean isValid(MovieDTO movieDTO) throws InvalidMovieRequestBodyException {
        if(movieDTO.getMovieName() == null || movieDTO.getMovieName() == ""){
            throw new InvalidMovieRequestBodyException("Movie Name is empty or null");
        }

        if(movieDTO.getMovieDescription() == null || movieDTO.getMovieDescription() == ""){
            throw new InvalidMovieRequestBodyException("Description is empty or null");
        }

        if(movieDTO.getCoverPhotoUrl() == null || movieDTO.getCoverPhotoUrl() == ""){
            throw new InvalidMovieRequestBodyException("cover photo url is empty or null");
        }

        if(movieDTO.getReleaseDate() == null){
            throw new InvalidMovieRequestBodyException("Release Date is empty or null");
        }

        if(movieDTO.getDuration()>180 || movieDTO.getDuration() <45){
            throw new InvalidMovieRequestBodyException("Movie Duration should lie b/w 45-100 mins");
        }

        if(movieDTO.getSatusId() <0){
            throw new InvalidMovieRequestBodyException("Status ID is empty or null");
        }

        return true;
    }
}
