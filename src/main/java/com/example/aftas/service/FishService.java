package com.example.aftas.service;

import com.example.aftas.domain.Fish;
import com.example.aftas.domain.Level;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface FishService {

    Fish save(Fish fish);

    List<Fish> getAll();

    Fish getByName(String name);

    List<Fish> getByLevel(Level level);

    Fish getById(Long id);

    Fish update(Fish fish);

    void delete(Long id);

}