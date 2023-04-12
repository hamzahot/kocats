package com.academy.kocats.mappers;


import com.academy.kocats.dto.race.CatRaceDTO;
import com.academy.kocats.entities.Cat;
import com.academy.kocats.entities.Race;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface RaceMapper {


    Race toEntity(CatRaceDTO catRaceDTO);


    CatRaceDTO toDTO(Race race);



}
