package com.academy.kocats.services;


import com.academy.kocats.dto.donation.DonationDTO;
import com.academy.kocats.entities.Donation;
import com.academy.kocats.entities.ServiceType;
import com.academy.kocats.mappers.DonationMapper;
import com.academy.kocats.repositories.DonationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonationService {


    @Autowired
    private DonationRepository donationRepository;

    @Autowired
    private DonationMapper donationMapper;


    public void insert(DonationDTO donationDTO) {

        Donation donation = donationMapper.toEntity(donationDTO);

        ServiceType serviceType = new ServiceType();
        serviceType.setPrice(donationDTO.getAmount());
        serviceType.setCategory("donation");

        donation.setServiceType(serviceType);

        donationRepository.save(donation);
    }


    public List<DonationDTO> getAll() {
        return donationRepository.getAll().stream().map(donationMapper :: toDonationDTO).toList();
    }


    public DonationDTO getDonationById(Integer id){
        return donationMapper.toDonationDTO(donationRepository.getDonationById(id));
    }


    public void deleteById(Integer id) {
        donationRepository.deleteById(id);
    }
}
