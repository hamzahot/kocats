package com.academy.kocats.services;


import com.academy.kocats.dto.race.CatRaceDTO;
import com.academy.kocats.mappers.RaceMapper;
import com.academy.kocats.repositories.RaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class RaceService {

    @Autowired
    private RaceMapper raceMapper;

    @Autowired
    private RaceRepository raceRepository;


    public List<CatRaceDTO> getAll() {
       return raceRepository.findAll().stream().map(raceMapper :: toDTO).toList();
    }

    public CatRaceDTO getById(Integer id) {
        return raceMapper.toDTO(raceRepository.findById(id).get());
    }
}
