package com.fatina.wckunder.repo;

import com.fatina.wckunder.model.Booking;
import com.fatina.wckunder.model.User;

import java.util.List;
import java.util.Optional;

public interface BookingServiceRepository {
    Booking saveBooking(Booking booking);
    List<Booking> getAllBookings();


    List<Booking> getBookingById(User user);

    Booking updateBooking(Booking booking);

    Booking cancelBooking(Booking booking);
}
