package com.simplemovie.repository;

import com.simplemovie.entity.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface ShowRepository extends JpaRepository<Show,Integer> {

    List<Show> findByMovieMovieId(int movieId);
}
