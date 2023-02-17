package com.academy.kocats.mappers;


import com.academy.kocats.dto.donation.DonationDTO;
import com.academy.kocats.entities.Donation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface DonationMapper {

    Donation toEntity(DonationDTO donationDTO);


    @Mapping(source = "donation.serviceType.price" , target = "amount")
    DonationDTO toDonationDTO(Donation donation);



}
