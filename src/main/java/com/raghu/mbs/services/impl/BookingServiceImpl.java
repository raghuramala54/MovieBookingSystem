package com.raghu.mbs.services.impl;

import com.raghu.mbs.daos.BookingDao;
import com.raghu.mbs.entities.Booking;
import com.raghu.mbs.exceptions.BookingDetailsNotFoundException;
import com.raghu.mbs.exceptions.MovieTheatreDetailsNotFoundException;
import com.raghu.mbs.exceptions.UserDetailsNotFoundException;
import com.raghu.mbs.services.BookingService;
import com.raghu.mbs.services.MovieTheatreService;
import com.raghu.mbs.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    public MovieTheatreService movieTheatreService;

    @Autowired
    public UserService userService;

    @Autowired
    public BookingDao bookingDao;

    @Override
    public Booking acceptBookingDetails(Booking booking) throws MovieTheatreDetailsNotFoundException,
            UserDetailsNotFoundException {
        movieTheatreService.getMovieTheatreDetails(booking.getMovieTheatre().getMovieTheatreId());
        userService.getUserDetails(booking.getUser().getCustomerId());
        bookingDao.save(booking);
        return booking;
    }

    @Override
    public Booking getBookingDetails(int id) throws BookingDetailsNotFoundException {
        return bookingDao.findById(id)
                .orElseThrow(
                        () -> new BookingDetailsNotFoundException("Booking not found for id: " + id)
                );
    }

    @Override
    public boolean deleteBooking(int id) throws BookingDetailsNotFoundException {
        Booking booking = getBookingDetails(id);
        bookingDao.delete(booking);
        return true;
    }

    @Override
    public List<Booking> getAllBookingDetails() {
        return bookingDao.findAll();
    }
}
