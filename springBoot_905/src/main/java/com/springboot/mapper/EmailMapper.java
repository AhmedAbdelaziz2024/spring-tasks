package com.springboot.mapper;

import com.springboot.dto.EmailDTO;
import com.springboot.model.Email;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmailMapper {

    @Mapping(target = "employee.id", source = "employeeId")
    Email toEntity(EmailDTO dto);

    @Mapping(target = "employeeId", source = "employee.id")
    EmailDTO toDto(Email email);

    List<EmailDTO> toDtoList(List<Email> emails);

    List<Email> toEntityList(List<EmailDTO> dtos);
}
