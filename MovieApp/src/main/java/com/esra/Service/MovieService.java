package com.esra.Service;

import com.esra.entity.Movie;
import com.esra.repository.MovieRepository;
import com.esra.utility.ICrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieService implements ICrudService<Movie,Long> {
    private final MovieRepository movieRepository;

    @Override
    public Movie save(Movie movie) {
        return null;
    }

    @Override
    public Movie update(Movie movie) {
        return null;
    }

    @Override
    public Iterable<Movie> saveAll(Iterable<Movie> t) {
        return null;
    }

    @Override
    public Movie deleteById(Long aLong) {
        return null;
    }

    @Override
    public Optional<Movie> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existById(Long aLong) {
        return false;
    }

    @Override
    public List<Movie> findAll() {
        return null;
    }

    @Override
    public List<Movie> findByColumnAndValue(String columnName, Object value) {
        return null;
    }

    public Optional<Movie> findByName(String name){
        return movieRepository.findByName(name);
    }
    public List<Movie> findAllByRaiting(Double value) {
        return movieRepository.findAllByRating(value);
    }
    public List<Movie> findAllByPremiere(LocalDate date) {
        return movieRepository.findAllByPremiered(date);
    }
    public List<Movie> findAllByRatingBetween(Double min, Double max) {
        return movieRepository.findAllByRatingBetween(min,max);
    }
}
