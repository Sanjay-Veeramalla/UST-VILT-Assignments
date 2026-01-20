package com.simplemovie.controller;

import com.simplemovie.entity.Booking;
import com.simplemovie.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/bookings")
    public String bookTickets(@RequestBody Booking booking){
        return bookingService.bookTickets(booking);
    }

    @GetMapping("/bookings")
    public List<Booking> getAllBookings(){
        return bookingService.getAllBookings();
    }

    @DeleteMapping("/bookings/{bookingId}")
    public String cancelBooking(@PathVariable int bookingId){
        return bookingService.cancelBooking(bookingId);

    }
}

