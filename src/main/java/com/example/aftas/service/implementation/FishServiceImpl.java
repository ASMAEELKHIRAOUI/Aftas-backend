package com.example.aftas.service.implementation;

import com.example.aftas.domain.Fish;
import com.example.aftas.domain.Level;
import com.example.aftas.service.FishService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FishServiceImpl implements FishService {
    @Override
    public Fish save(Fish fish) {
        return null;
    }

    @Override
    public List<Fish> getAll() {
        return null;
    }

    @Override
    public Fish getByName(String name) {
        return null;
    }

    @Override
    public List<Fish> getByLevel(Integer code) {
        return null;
    }

    @Override
    public Fish getById(Long id) {
        return null;
    }

    @Override
    public Fish update(Fish fish, Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
