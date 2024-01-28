package com.esra.controller;

import com.esra.Service.MovieCommentService;
import com.esra.Service.MovieService;
import com.esra.entity.Movie;
import com.esra.entity.MovieComment;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/movie-comment")
public class MovieCommentController {
    private final MovieCommentService movieCommentService;
    private final MovieService movieService;
    @GetMapping("/find-all-comments-by-movie-name")
    public List<MovieComment> findAllCommentsByMovieName(String movieName){
        Optional<Movie> movie = movieService.findByName(movieName);
        if(movie.isEmpty())
            throw new RuntimeException("Film bulunamadı. "+movieName);
        return movieCommentService.findAllByMovieId(movie.get().getId());
    }
    @GetMapping("/find-all-comments-between-date")
    public List<MovieComment> findAllCommentsBetweenDate(String startDate, String endDate){
        return movieCommentService.findAllBetweenDate(startDate, endDate);
    }
    @GetMapping("/find-all-comments-by-length")
    public List<MovieComment> findAllCommentsByLength(int value){
        return movieCommentService.findAllCommentsByLength(value);
    }
}


