package com.academy.kocats.mappers;


import com.academy.kocats.dto.cat.command.CatCreateDTO;
import com.academy.kocats.dto.cat.command.CatUpdateDTO;
import com.academy.kocats.dto.cat.query.CatGetDTO;
import com.academy.kocats.entities.Cat;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface CatMapper {

   // @Mapping(source = "photos", target = "catPhotos")
    Cat toEntity(CatCreateDTO catCreateDTO);

    Cat updateDTOtoEntity(CatUpdateDTO catUpdateDTO);


//////////////obavezno da se ispravii



    CatGetDTO toGetDTO(Cat cat);

}
