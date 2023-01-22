package com.academy.kocats.repositories;

import com.academy.kocats.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {




}
