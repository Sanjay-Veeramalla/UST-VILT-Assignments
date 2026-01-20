package com.simplemovie.service;

import com.simplemovie.entity.Movie;
import com.simplemovie.entity.Show;
import com.simplemovie.repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ShowService {

    @Autowired
    private ShowRepository showRepository;

    public String createShow(Show show) {
        Show newShow=new Show();
        newShow.setShowTime(show.getShowTime());
        newShow.setTotalSeats(show.getTotalSeats());
        newShow.setAvailableSeats(show.getAvailableSeats());
        newShow.setMovie(show.getMovie());
        showRepository.save(newShow);
        return "Show Created Successfully!";
    }

    public List<Show> getAllShows() {
        return showRepository.findAll();
    }

    public List<Show> getShowsByMovie(int movieId) {
        return showRepository.findByMovieMovieId(movieId);

    }
}
