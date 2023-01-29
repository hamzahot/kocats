package com.academy.kocats.services;


import com.academy.kocats.dto.cat.command.CatCreateDTO;
import com.academy.kocats.entities.Cat;
import com.academy.kocats.entities.CatPhoto;
import com.academy.kocats.entities.Race;
import com.academy.kocats.mappers.CatMapper;
import com.academy.kocats.mappers.PhotoMapper;
import com.academy.kocats.mappers.RaceMapper;
import com.academy.kocats.repositories.CatRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CatService {


    @Autowired
    private CatMapper catMapper;

    @Autowired
    private RaceMapper raceMapper;

    @Autowired
    private CatRepository catRepository;

    @Autowired
    private PhotoMapper photoMapper;

    public void insert(CatCreateDTO catCreateDTO) {

        Cat cat = catMapper.toEntity(catCreateDTO);

        for(CatPhoto catPhoto : cat.getCatPhotos()){
            catPhoto.setCat(cat);
        }

        Set<Race> set = catCreateDTO.getRaces().stream().map(raceMapper::toEntity).collect(Collectors.toSet());
        if ( set != null ) {
            cat.setBreeds( new HashSet<Race>( set ) );
        }

        catRepository.save(cat);

    }

    public void deleteById(Integer id) {
        catRepository.deleteById(id);
    }

    public void update(Integer id, CatCreateDTO catCreateDTO) {

        Cat cat = catRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Not found!"));

        List<CatPhoto> list = catCreateDTO.getPhotos().stream().map(photoMapper::toEntity).toList();
        for(CatPhoto catPhoto : list){
            catPhoto.setCat(cat);
        }
        if(list != null){
            List<CatPhoto> lista = cat.getCatPhotos();
            lista.addAll(list);
            cat.setCatPhotos(lista);
        }

        Set<Race> set = catCreateDTO.getRaces().stream().map(raceMapper::toEntity).collect(Collectors.toSet());
        if ( set != null ) {
            cat.setBreeds( new HashSet<Race>( set ) );
        }

        cat.setName( catCreateDTO.getName() );

        catRepository.save(cat);

    }
}
