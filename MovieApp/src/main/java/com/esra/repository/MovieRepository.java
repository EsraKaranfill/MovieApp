package com.esra.repository;

import com.esra.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie,Long> {

    List<Movie> findAllByRating(Double value);

    List<Movie> findAllByPremiered(LocalDate date);
    List<Movie> findAllByRatingBetween(Double min, Double max);

    Optional<Movie> findByName(String name);
}
