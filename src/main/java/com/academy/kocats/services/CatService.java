package com.academy.kocats.services;


import com.academy.kocats.dto.cat.command.CatCreateDTO;
import com.academy.kocats.entities.Cat;
import com.academy.kocats.entities.CatPhoto;
import com.academy.kocats.mappers.CatMapper;
import com.academy.kocats.repositories.CatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CatService {


    @Autowired
    private CatMapper catMapper;

    @Autowired
    private CatRepository catRepository;

    public void insert(CatCreateDTO catCreateDTO) {

        Cat cat = catMapper.toEntity(catCreateDTO);

        for(CatPhoto catPhoto : cat.getCatPhotos()){
            catPhoto.setCat(cat);
        }

        catRepository.save(cat);

    }

    public void deleteById(Integer id) {
        catRepository.deleteById(id);
    }
}
