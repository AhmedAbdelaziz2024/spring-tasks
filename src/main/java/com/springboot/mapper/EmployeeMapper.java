package com.springboot.mapper;

import com.springboot.dto.EmployeeDTO;
import com.springboot.model.Employee;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {EmailMapper.class})
public interface EmployeeMapper {

    EmployeeDTO toDto(Employee employee);

    Employee toEntity(EmployeeDTO dto);

    List<EmployeeDTO> toDtoList(List<Employee> employees);

    List<Employee> toEntityList(List<EmployeeDTO> dtos);
}
