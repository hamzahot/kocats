package com.academy.kocats.repositories;


import com.academy.kocats.entities.Action;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActionRepository extends JpaRepository<Action, Integer> {


    @Query(value = "select action " +
            "from Action action " +
            "join fetch action.serviceType")
    List<Action> getAll();


    @Query(value = "select action " +
            "from Action action " +
            "join fetch action.serviceType " +
            "where action.id = :id")
    Action getById(@Param("id") Integer id);

}
