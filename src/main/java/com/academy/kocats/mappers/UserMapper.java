package com.academy.kocats.mappers;


import com.academy.kocats.dto.user.command.UserCreateDTO;
import com.academy.kocats.dto.user.query.UserGetDTO;
import com.academy.kocats.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface UserMapper {


    User toEntity(UserCreateDTO userCreateDTO);




    @Mapping(source = "userId", target="id")
    UserGetDTO toGetDTO(User user);

}
