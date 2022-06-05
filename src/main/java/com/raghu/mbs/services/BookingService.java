package com.raghu.mbs.services;

import com.raghu.mbs.entities.Booking;
import com.raghu.mbs.exceptions.BookingDetailsNotFoundException;
import com.raghu.mbs.exceptions.MovieTheatreDetailsNotFoundException;
import com.raghu.mbs.exceptions.UserDetailsNotFoundException;

import java.util.List;
public interface BookingService {
    public Booking acceptBookingDetails(Booking booking) throws MovieTheatreDetailsNotFoundException,
            UserDetailsNotFoundException;
    public Booking getBookingDetails(int id) throws BookingDetailsNotFoundException;
    public boolean deleteBooking(int id) throws BookingDetailsNotFoundException;
    public List<Booking> getAllBookingDetails();
}
