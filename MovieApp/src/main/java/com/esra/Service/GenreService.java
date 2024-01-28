package com.esra.Service;

import com.esra.entity.Genre;
import com.esra.utility.ICrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GenreService implements ICrudService<Genre,Long> {
    @Override
    public Genre save(Genre genre) {
        return null;
    }

    @Override
    public Genre update(Genre genre) {
        return null;
    }

    @Override
    public Iterable<Genre> saveAll(Iterable<Genre> t) {
        return null;
    }

    @Override
    public Genre deleteById(Long aLong) {
        return null;
    }

    @Override
    public Optional<Genre> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existById(Long aLong) {
        return false;
    }

    @Override
    public List<Genre> findAll() {
        return null;
    }

    @Override
    public List<Genre> findByColumnAndValue(String columnName, Object value) {
        return null;
    }
}
