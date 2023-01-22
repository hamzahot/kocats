package com.academy.kocats.repositories;

import com.academy.kocats.entities.Cat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatRepository extends JpaRepository<Cat, Integer> {



}
