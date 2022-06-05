package com.raghu.mbs.daos;

import com.raghu.mbs.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/*All the CRUD operations will be available now*/

public interface MovieDao extends JpaRepository<Movie,Integer> {

    //we can define the signature of the methods in this interface
    //follow some naming conventions

    //find<EntityName>By<ColumnName>
    //I want to provide support to search by name
    public Movie findMovieByMovieName(String movieName);

    //I want to search based on both name and duration
    public Movie findMovieByMovieNameAndDuration(String movieName,int duration);

    //I want to search based on conditions
    public List<Movie> findByDurationGreaterThanEqual(int duration);

    public List<Movie> findByMovieNameContaining(int duration);

    public List<Movie> findMovieByMovieNameIgnoreCase(String movie);
}
