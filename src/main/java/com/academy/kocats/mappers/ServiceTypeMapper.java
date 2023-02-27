package com.academy.kocats.mappers;


import com.academy.kocats.dto.service_type.ServiceTypeDTO;
import com.academy.kocats.entities.ServiceType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface ServiceTypeMapper {


    ServiceTypeDTO toServiceTypeDTO(ServiceType serviceType);

}
