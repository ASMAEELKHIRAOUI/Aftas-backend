package com.example.aftas.service.implementation;

import com.example.aftas.domain.Competition;
import com.example.aftas.domain.Fish;
import com.example.aftas.domain.Hunting;
import com.example.aftas.domain.Member;
import com.example.aftas.service.HuntingService;

import java.util.List;

public class HuntingServiceImpl implements HuntingService {
    @Override
    public Hunting save(Hunting hunting) {
        return null;
    }

    @Override
    public List<Hunting> getAll() {
        return null;
    }

    @Override
    public Hunting getById(Long id) {
        return null;
    }

    @Override
    public Hunting update(Hunting hunting) {
        return null;
    }

    @Override
    public void checkIfFishAlreadyHunted(Member member, Competition competition, Fish fish) {

    }

    @Override
    public void delete(Long id) {

    }
}