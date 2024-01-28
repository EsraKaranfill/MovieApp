package com.esra.controller;

import com.esra.Service.MovieService;
import com.esra.entity.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/movie")
public class MovieController {
    private final MovieService movieService;
    @GetMapping("/find-all-by-raiting")
    public List<Movie> findAllByRaiting(Double value){
        return movieService.findAllByRaiting(value);
    }
    @GetMapping("/find-all-by-premiered")
    public List<Movie> findAllByPremiered(LocalDate date){
        return movieService.findAllByPremiere(date);
    }
    @GetMapping("/find-all-by-rating-between")
    public List<Movie> findAllByRatingBetween(Double min, Double max) {
        return movieService.findAllByRatingBetween(min, max);
    }
    @GetMapping("/find-by-name")
    public Optional<Movie> findByName(String name){
        return movieService.findByName(name);
    }

}
