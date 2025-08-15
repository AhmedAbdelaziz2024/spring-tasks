package com.springboot.mapper;

import com.springboot.dto.StudentSimpleDTO;
import com.springboot.dto.TeacherDTO;
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
public class TeacherMapperImpl implements TeacherMapper {

    @Override
    public TeacherDTO toDTO(Teacher teacher) {
        if ( teacher == null ) {
            return null;
        }

        TeacherDTO teacherDTO = new TeacherDTO();

        teacherDTO.setId( teacher.getId() );
        teacherDTO.setName( teacher.getName() );
        teacherDTO.setStudents( studentSetToStudentSimpleDTOSet( teacher.getStudents() ) );

        return teacherDTO;
    }

    protected StudentSimpleDTO studentToStudentSimpleDTO(Student student) {
        if ( student == null ) {
            return null;
        }

        StudentSimpleDTO studentSimpleDTO = new StudentSimpleDTO();

        studentSimpleDTO.setId( student.getId() );
        studentSimpleDTO.setName( student.getName() );

        return studentSimpleDTO;
    }

    protected Set<StudentSimpleDTO> studentSetToStudentSimpleDTOSet(Set<Student> set) {
        if ( set == null ) {
            return null;
        }

        Set<StudentSimpleDTO> set1 = new LinkedHashSet<StudentSimpleDTO>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Student student : set ) {
            set1.add( studentToStudentSimpleDTO( student ) );
        }

        return set1;
    }
}
