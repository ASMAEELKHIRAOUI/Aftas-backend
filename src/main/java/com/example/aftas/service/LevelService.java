package com.example.aftas.service;

import com.example.aftas.domain.Level;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface LevelService {

    Level save(Level level);

    List<Level> getAll();

    Level getById(Long id);

    Level getByCode(Integer code);

    Level update(Level level, Long id);

    void delete(Long id);

    Boolean checkIfLevelIsValid(Level level);

}
