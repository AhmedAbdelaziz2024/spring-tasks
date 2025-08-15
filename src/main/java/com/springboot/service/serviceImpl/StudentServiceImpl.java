package com.springboot.service.serviceImpl;

import com.springboot.dto.StudentDTO;
import com.springboot.mapper.StudentMapper;
import com.springboot.model.Student;
import com.springboot.repository.StudentRepo;
import com.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepo studentRepository;
    private  StudentMapper studentMapper;
    @Autowired
    public StudentServiceImpl(StudentRepo studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    @Override
    public List<StudentDTO> getAllStudentsWithTeachers() {
        return studentRepository.findAll()
                .stream()
                .map(studentMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public StudentDTO getStudentWithTeachersById(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        return studentMapper.toDTO(student);
    }
}
