package com.raghu.mbs.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.raghu.mbs.entities.Status;
import com.raghu.mbs.entities.Theatre;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class MovieDTO {

    @JsonProperty("movie_id")
    private int movieId;

    @JsonProperty("movie_name")
    private String movieName;

    @JsonProperty("movie_desc")
    private String movieDescription;

    @JsonProperty("release_date")
    private LocalDateTime releaseDate;


    private double duration;

    @JsonProperty("cover_photo_url")
    private String coverPhotoUrl;

    @JsonProperty("trailer_url")
    private String trailerUrl;

    public int getSatusId() {
        return satusId;
    }

    public void setSatusId(int satusId) {
        this.satusId = satusId;
    }

    @JsonProperty("status_id")
    private int satusId;

    public int getMovieId() {
        return movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getMovieDescription() {
        return movieDescription;
    }

    public LocalDateTime getReleaseDate() {
        return releaseDate;
    }

    public double getDuration() {
        return duration;
    }

    public String getCoverPhotoUrl() {
        return coverPhotoUrl;
    }

    public String getTrailerUrl() {
        return trailerUrl;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public void setMovieDescription(String movieDescription) {
        this.movieDescription = movieDescription;
    }

    public void setReleaseDate(LocalDateTime releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public void setCoverPhotoUrl(String coverPhotoUrl) {
        this.coverPhotoUrl = coverPhotoUrl;
    }

    public void setTrailerUrl(String trailerUrl) {
        this.trailerUrl = trailerUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieDTO movieDTO = (MovieDTO) o;
        return movieId == movieDTO.movieId && Double.compare(movieDTO.duration, duration) == 0 && Objects.equals(movieName, movieDTO.movieName) && Objects.equals(movieDescription, movieDTO.movieDescription) && Objects.equals(releaseDate, movieDTO.releaseDate) && Objects.equals(coverPhotoUrl, movieDTO.coverPhotoUrl) && Objects.equals(trailerUrl, movieDTO.trailerUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movieId, movieName, movieDescription, releaseDate, duration, coverPhotoUrl, trailerUrl);
    }

    @Override
    public String toString() {
        return "MovieDTO{" +
                "movieId=" + movieId +
                ", movieName='" + movieName + '\'' +
                ", movieDescription='" + movieDescription + '\'' +
                ", releaseDate=" + releaseDate +
                ", duration=" + duration +
                ", coverPhotoUrl='" + coverPhotoUrl + '\'' +
                ", trailerUrl='" + trailerUrl + '\'' +
                '}';
    }
}
