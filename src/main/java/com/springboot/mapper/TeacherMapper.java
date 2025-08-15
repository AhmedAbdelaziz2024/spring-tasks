package com.springboot.mapper;

import com.springboot.dto.TeacherDTO;
import com.springboot.model.Teacher;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TeacherMapper {
    TeacherDTO toDTO(Teacher teacher);
}
