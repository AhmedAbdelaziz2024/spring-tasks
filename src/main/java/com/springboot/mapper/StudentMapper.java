package com.springboot.mapper;

import com.springboot.dto.StudentDTO;
import com.springboot.model.Student;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    StudentDTO toDTO(Student student);
}
