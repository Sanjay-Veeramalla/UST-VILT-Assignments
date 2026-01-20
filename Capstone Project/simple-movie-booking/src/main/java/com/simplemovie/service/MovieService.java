package com.simplemovie.service;

import com.simplemovie.entity.Movie;
import com.simplemovie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public String addMovie(Movie movie) {
        Movie newMovie=new Movie();
        newMovie.setTitle(movie.getTitle());
        newMovie.setGenre(movie.getGenre());
        newMovie.setDuration(movie.getDuration());
        movieRepository.save(newMovie);
        return "Movie Added Successfully!";
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }
}
