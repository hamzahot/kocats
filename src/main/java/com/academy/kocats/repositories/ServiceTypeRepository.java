package com.academy.kocats.repositories;


import com.academy.kocats.entities.Product;
import com.academy.kocats.entities.ServiceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceTypeRepository extends JpaRepository<ServiceType, Integer> {





    @Query(value = "select serviceType " +
            "from ServiceType serviceType")
    List<ServiceType> getAllServiceTypes();



    @Query(value = "select serviceType " +
            "from ServiceType serviceType " +
            "where serviceType.serviceTypeId = :id")
    ServiceType getServiceTypeById(Integer id);
}
