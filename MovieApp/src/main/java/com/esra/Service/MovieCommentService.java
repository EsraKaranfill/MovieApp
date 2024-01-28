package com.esra.Service;

import com.esra.entity.MovieComment;
import com.esra.repository.MovieCommentRepository;
import com.esra.utility.ICrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieCommentService implements ICrudService<MovieComment,Long> {
    private final MovieCommentRepository movieCommentRepository;
    @Override
    public MovieComment save(MovieComment entity) {
        return null;
    }

    @Override
    public MovieComment update(MovieComment entity) {
        return null;
    }

    @Override
    public Iterable<MovieComment> saveAll(Iterable<MovieComment> t) {
        return null;
    }


    @Override
    public boolean existById(Long aLong) {
        return false;
    }

    @Override
    public List<MovieComment> findAll() {
        return null;
    }

    @Override
    public List<MovieComment> findByColumnAndValue(String columnName, Object value) {
        return null;
    }

    @Override
    public MovieComment deleteById(Long aLong) {
        return null;
    }

    @Override
    public Optional<MovieComment> findById(Long aLong) {
        return Optional.empty();
    }

    public List<MovieComment> findAllByMovieId(Long id) {
        Optional<List<MovieComment>> movieCommentList=movieCommentRepository.findAllByMovieId(id);
        if (movieCommentList.isEmpty())
            throw new RuntimeException("Bu id'ye ait yorumlar bulunamadı "+id);
        return movieCommentList.get();
    }

    public List<MovieComment> findAllBetweenDate(String startDate, String endDate) {
        Optional<List<MovieComment>> movieCommentList=movieCommentRepository.findAllBetweenDate(startDate,endDate);
        if (movieCommentList.isEmpty())
            throw new RuntimeException("There is no comment between "+startDate+" and "+endDate);
        return movieCommentList.get();
    }

    public List<MovieComment> findAllCommentsByLength(int value) {
        Optional<List<MovieComment>> movieCommentList= Optional.ofNullable(movieCommentRepository.findAllByCommentLength(value));
        if (movieCommentList.isEmpty())
            throw new RuntimeException("Bu uzunlukta yorum bulunamadı. "+value);
        return movieCommentList.get();
    }
}


