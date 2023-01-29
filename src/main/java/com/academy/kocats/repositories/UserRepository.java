package com.academy.kocats.repositories;

import com.academy.kocats.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {



    @Query(value = "select user from User as user")
    List<User> findAllUsers();


    User findByUserId(Integer id);


    @Query(value = "select user from User as user " +
            "join fetch user.roles " +
            "where user.id = :id")
    User findWithRolesById(@Param(value = "id") Integer id);


    @Query(value = "select user " +
            "from User user " +
            "join fetch user.purchases " +
            "where user.id = :id")
    User findByUserIdWithPurchase(@Param("id") int id);


//    @Modifying
//    @Query(value = "delete from user_role where user_id = :id")
//    void deleteUserwithId(@Param(value = "id") Integer id);





}
