package com.simplemovie.controller;

import com.simplemovie.entity.Movie;
import com.simplemovie.entity.Show;
import com.simplemovie.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ShowController {

    @Autowired
    private ShowService showService;

    @PostMapping("/shows")
    public String createShow(@RequestBody Show show){
        return showService.createShow(show);
    }

    @GetMapping("/shows")
    public List<Show> getAllShows(){
        return showService.getAllShows();
    }

    @GetMapping("/shows/movie/{movieId}")
    public List<Show> getShowsByMovie(@PathVariable int movieId){
        return showService.getShowsByMovie(movieId);
    }

}
