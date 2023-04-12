package com.academy.kocats.controllers;

import com.academy.kocats.dto.race.CatRaceDTO;
import com.academy.kocats.services.RaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/race")
public class RaceController {


    @Autowired
    private RaceService raceService;


    @GetMapping
    public ResponseEntity<List<CatRaceDTO>> getAll(){
        List<CatRaceDTO> raceDTOS =  raceService.getAll();
        return new ResponseEntity<>(raceDTOS, HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<CatRaceDTO> getById(@PathVariable("id") Integer id){
        CatRaceDTO catRaceDTO = raceService.getById(id);
        return new ResponseEntity<>(catRaceDTO, HttpStatus.OK);
    }


}
