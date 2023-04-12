package com.academy.kocats.repositories;

import com.academy.kocats.entities.Cat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CatRepository extends JpaRepository<Cat, Integer> {


    @Query(value =
            "select cat from Cat as cat " +
            "join fetch cat.breeds")
    List<Cat> getAllCatsWithBreeds();


    @Query(value = "select cat from Cat as cat " +
            "join fetch cat.breeds " +
            "where cat.catId = :id")
    Cat findByIdWithBreeds(@Param("id") Integer id);



    Cat findByCatId(Integer id);


}
