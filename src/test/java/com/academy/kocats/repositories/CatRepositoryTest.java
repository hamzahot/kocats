package com.academy.kocats.repositories;


import com.academy.kocats.KocatsApplication;
import com.academy.kocats.dto.cat.command.CatCreateDTO;
import com.academy.kocats.dto.race.CatRaceDTO;
import com.academy.kocats.entities.Cat;
import com.academy.kocats.entities.CatPhoto;
import com.academy.kocats.mappers.CatMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Slf4j
@ActiveProfiles("dev")
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = KocatsApplication.class)
public class CatRepositoryTest {


    @Autowired
    private CatRepository catRepository;


    @Autowired
    private PhotoRepository photoRepository;

    @Autowired
    private CatMapper catMapper;


//    @Test
//    void shouldReturnAllCats(){
//        List<Cat> cats = catRepository.getAllCats();
//        assertThat(cats).isNotEmpty();
//        log.info(String.valueOf(cats.get(0).getBreeds()));
//        log.info(cats.get(0).getStatuses().toString());
//    }


    @Test
    void shouldSaveNewCat(){

//        Cat cat = new Cat();
//        cat.setName("Cat 3");
//
//        catRepository.save(cat);


        CatCreateDTO catDTO = new CatCreateDTO();
        catDTO.setName("test cat");

        CatRaceDTO catRaceDTO1 = new CatRaceDTO();
        catRaceDTO1.setRaceId(9);
        CatRaceDTO catRaceDTO2 = new CatRaceDTO();
        catRaceDTO2.setRaceId(10);
        Set<CatRaceDTO> set = new HashSet<>();
        set.add(catRaceDTO1);
        set.add(catRaceDTO2);

        catDTO.setBreeds(set);

        Cat cat = catMapper.toEntity(catDTO);

        catRepository.save(cat);


        //catDTO.setRaces();


    }

    @Test
    void shouldDeleteCat(){
        Cat cat = catRepository.findByCatId(7);

        catRepository.delete(cat);


    }


    @Test
    void shouldSavePhot(){
        CatPhoto catPhoto = new CatPhoto();
        catPhoto.setFullPath("test");
        catPhoto.setName("test");

        Cat cat = new Cat();
        cat.setCatId(17);

        catPhoto.setCat(cat);
        photoRepository.save(catPhoto);

    }


    @Test
    void shouldGetFullPathById(){
        String path = photoRepository.fullPathById(40);
        log.info(path);
    }





}
