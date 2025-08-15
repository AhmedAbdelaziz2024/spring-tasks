package com.springboot.mapper;

import com.springboot.dto.StudentDTO;
import com.springboot.dto.TeacherSimpleDTO;
import com.springboot.model.Student;
import com.springboot.model.Teacher;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-15T18:56:14+0300",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class StudentMapperImpl implements StudentMapper {

    @Override
    public StudentDTO toDTO(Student student) {
        if ( student == null ) {
            return null;
        }

        StudentDTO studentDTO = new StudentDTO();

        studentDTO.setId( student.getId() );
        studentDTO.setName( student.getName() );
        studentDTO.setTeachers( teacherSetToTeacherSimpleDTOSet( student.getTeachers() ) );

        return studentDTO;
    }

    protected TeacherSimpleDTO teacherToTeacherSimpleDTO(Teacher teacher) {
        if ( teacher == null ) {
            return null;
        }

        TeacherSimpleDTO teacherSimpleDTO = new TeacherSimpleDTO();

        teacherSimpleDTO.setId( teacher.getId() );
        teacherSimpleDTO.setName( teacher.getName() );

        return teacherSimpleDTO;
    }

    protected Set<TeacherSimpleDTO> teacherSetToTeacherSimpleDTOSet(Set<Teacher> set) {
        if ( set == null ) {
            return null;
        }

        Set<TeacherSimpleDTO> set1 = new LinkedHashSet<TeacherSimpleDTO>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Teacher teacher : set ) {
            set1.add( teacherToTeacherSimpleDTO( teacher ) );
        }

        return set1;
    }
}
