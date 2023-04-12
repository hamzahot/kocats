package com.academy.kocats.mappers;


import com.academy.kocats.dto.role.RoleDTO;
import com.academy.kocats.entities.Role;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface RoleMapper {


    //@Mapping(source = "id", target="roleId")
    Role toEntity(RoleDTO roleDTO);



    //@Mapping(source = "roleId", target="id")
    RoleDTO toDTO(Role role);

}
