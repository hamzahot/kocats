package com.academy.kocats.mappers;


import com.academy.kocats.dto.photo.PhotoDTO;
import com.academy.kocats.entities.CatPhoto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface PhotoMapper {



    CatPhoto toEntity(PhotoDTO photoDTO);

}
