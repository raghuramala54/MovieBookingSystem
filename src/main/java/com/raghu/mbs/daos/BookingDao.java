package com.raghu.mbs.daos;

import com.raghu.mbs.entities.Booking;
import com.raghu.mbs.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingDao extends JpaRepository<Booking,Integer> {
    //public Booking findByBookingId(int bookingId);
}
