package com.academy.kocats.mappers;

import com.academy.kocats.dto.action.command.ActionCreateDTO;
import com.academy.kocats.dto.action.command.ActionUpdateDTO;
import com.academy.kocats.dto.action.query.ActionQueryDTO;
import com.academy.kocats.entities.Action;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface ActionMapper {

    Action toEntity(ActionCreateDTO actionCreateDTO);


    Action updateDTOtoEntity(ActionUpdateDTO actionUpdateDTO);

    @Mapping(source = "action.serviceType.price" , target = "price")
    ActionQueryDTO toActionQueryDTO(Action action);

}
