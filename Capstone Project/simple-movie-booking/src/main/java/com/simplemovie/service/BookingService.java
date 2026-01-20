package com.simplemovie.service;

import com.simplemovie.entity.Booking;
import com.simplemovie.entity.Show;
import com.simplemovie.repository.BookingRepository;
import com.simplemovie.repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BookingService {
    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private BookingRepository bookingRepository;

    public String bookTickets(Booking booking) {
        Show show = showRepository.findById(
                booking.getShow().getShowId()
        ).orElseThrow(() -> new RuntimeException("Show not found"));
        if (booking.getSeatsBooked() > show.getAvailableSeats()) {
            throw new RuntimeException("Not enough seats available");
        }
        show.setAvailableSeats(
                show.getAvailableSeats() - booking.getSeatsBooked()
        );
        showRepository.save(show);
        booking.setBookingDate(LocalDate.now());
        bookingRepository.save(booking);
        return "Tickets Booked Successfully!";
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public String cancelBooking(int bookingId) {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        Show show = booking.getShow();
        show.setAvailableSeats(
                show.getAvailableSeats() + booking.getSeatsBooked()
        );

        showRepository.save(show);
        bookingRepository.delete(booking);
        return "Booking Cancelled Successfully!";
    }
}
