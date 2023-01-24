package com.academy.kocats.repositories;

import com.academy.kocats.entities.Cat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CatRepository extends JpaRepository<Cat, Integer> {


    @Query(value = "select cat from Cat as cat")
    List<Cat> getAllCats();


    Cat findByCatId(Integer id);


}
