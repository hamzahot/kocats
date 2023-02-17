package com.academy.kocats.repositories;


import com.academy.kocats.entities.Donation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DonationRepository extends JpaRepository<Donation, Integer> {


    @Query(value = "select donation " +
            "from Donation donation " +
            "join fetch donation.serviceType")
    List<Donation> getAll();


    @Query(value = "select donation " +
            "from Donation donation " +
            "join fetch donation.serviceType " +
            "where donation.id = :id")
    Donation getDonationById(Integer id);

}
