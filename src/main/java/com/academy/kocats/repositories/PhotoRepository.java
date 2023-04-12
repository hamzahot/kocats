package com.academy.kocats.repositories;

import com.academy.kocats.entities.CatPhoto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PhotoRepository extends JpaRepository<CatPhoto, Integer> {


    @Query(value = "select catPhoto.fullPath " +
            "from CatPhoto as catPhoto " +
            "where catPhoto.photoId = :id")
    String fullPathById(@Param("id") Integer id);



    @Query(value = "select catPhoto.name " +
            "from CatPhoto as catPhoto " +
            "where catPhoto.photoId = :id")
    String nameById(@Param("id") Integer id);



    @Query(value = "select catPhoto.name " +
            "from CatPhoto as catPhoto " +
            "where catPhoto.cat.catId = :id")
    List<String> getAllWithId(@Param("id") Integer id);



}
