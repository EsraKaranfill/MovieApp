package com.esra.repository;

import com.esra.entity.MovieComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface MovieCommentRepository extends JpaRepository<MovieComment,Long> {
    @Query("SELECT c FROM MovieComment c WHERE c.date BETWEEN ?1 AND ?2")
    Optional<List<MovieComment>> findAllBetweenDate(@Param("date") String startDate, String endDate);
    @Query("SELECT c FROM MovieComment c WHERE LENGTH(c.content) > :commentLength")
    List<MovieComment> findAllByCommentLength(@Param("commentLength") int commentLength);
    Optional<List<MovieComment>> findAllByMovieId(Long id);
}
