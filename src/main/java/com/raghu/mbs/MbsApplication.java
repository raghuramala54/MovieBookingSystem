package com.raghu.mbs;

import com.raghu.mbs.daos.MovieDao;
import com.raghu.mbs.entities.Movie;
import com.raghu.mbs.entities.Status;
import com.raghu.mbs.services.MovieService;
import com.raghu.mbs.services.StatusService;
import com.raghu.mbs.exceptions.StatusDetailsNotFoundException;
import com.raghu.mbs.services.impl.MovieServiceImpl;
import com.raghu.mbs.services.impl.StatusServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class MbsApplication {

	/***
	 * Writing logs
	 * initialize the logger
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(MbsApplication.class);

	public static void main(String[] args) throws StatusDetailsNotFoundException {
		ApplicationContext ctx = SpringApplication.run(MbsApplication.class, args);
/***    MovieDao movieDao=ctx.getBean(MovieDao.class);
		System.out.println(movieDao);
		System.out.println("Hello \n");

		Movie movie = new Movie();
		movie.setMovieName("shaangchi");
		movie.setMovieDescription("It's a great movie");
		movie.setReleaseDate(LocalDateTime.of(2021,6,27,5,30));
		movie.setDuration(150);
		movie.setCoverPhotoUrl("www.shaangchi/cover-photo-url");
		movie.setTrailerUrl("www.shaangchi/trailer-url");

		System.out.println("<------Before movie is stored------>");
		System.out.println(movie);
		System.out.println("<------After movie is started------>");
		Movie savedMovie = movieDao.save(movie); //provided by default
		System.out.println(savedMovie);

		System.out.println("<----Let's search the movie based on ID----->");
		Movie searchedMovie = movieDao.findById(savedMovie.getMovieId()).get();
		System.out.println(searchedMovie);

		System.out.println("<-----I want to update the movie record---->");
		System.out.println("Actual Movie Duration:"+searchedMovie.getDuration());
		searchedMovie.setDuration(250);

		Movie updateMovie =movieDao.save(searchedMovie);
		System.out.println("updateMovie Duration:"+searchedMovie.getDuration());

        System.out.println("<------Let's delete the record as well");
		movieDao.deleteById(updateMovie.getMovieId());

		System.out.println("<-----Search by the movie name------->");
		Movie foundByName = movieDao.findMovieByMovieName(updateMovie.getMovieName());
		System.out.println(foundByName); ***/

        //Let's test the status service
		StatusService statusService = ctx.getBean(StatusServiceImpl.class);
		System.out.println("StatusService Bean:"+statusService);

		Status status = new Status();
		status.setStatusName("RELEASED");
		statusService.acceptStatusDetails(status);

		Status status1 = new Status();
		status1.setStatusName("BLOCKED");
		statusService.acceptStatusDetails(status1);

		Status savedStatus = statusService.getStatusBasedOnId(1);
		System.out.println(savedStatus);

		//invalid id
		//Status savedStatusnew = statusService.getStatusBasedOnId(2);

		//Get the list of all the statuses
		List<Status> savedStatuses = statusService.getAllStatuses();
		System.out.println(savedStatuses);

		Movie movie =new Movie();
		movie.setDuration(150);
		movie.setMovieId(1);
		movie.setMovieName("Koi Mil Gya");
		movie.setMovieDescription("Awesome Movie by Alien");
		movie.setTrailerUrl("trailer_url");
		movie.setCoverPhotoUrl("cover_photo_url");
		movie.setReleaseDate(LocalDateTime.of(2021,04,05,03,23));
		movie.setStatus(status);

		MovieService movieService = ctx.getBean(MovieServiceImpl.class);
		movieService.acceptMovieDetails(movie);

		/** Debug Log **/
		LOGGER.debug("I am writing a debug log");

		/** Info Log **/
		LOGGER.info("I am writing an info log");

		LOGGER.warn("I amw writing a warning log");

		LOGGER.error("I am writing an error log");
	}

}
