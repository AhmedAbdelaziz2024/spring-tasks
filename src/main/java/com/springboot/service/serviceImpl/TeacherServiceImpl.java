package com.springboot.service.serviceImpl;

import com.springboot.dto.TeacherDTO;
import com.springboot.mapper.TeacherMapper;
import com.springboot.model.Teacher;
import com.springboot.repository.TeacherRepo;
import com.springboot.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeacherServiceImpl implements TeacherService {
    private TeacherRepo teacherRepository;
    private TeacherMapper teacherMapper;
    @Autowired
    public TeacherServiceImpl(TeacherRepo teacherRepository, TeacherMapper teacherMapper) {
        this.teacherRepository = teacherRepository;
        this.teacherMapper = teacherMapper;
    }

    @Override
    public List<TeacherDTO> getAllTeachersWithStudents() {
        return teacherRepository.findAll()
                .stream()
                .map(teacherMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TeacherDTO getTeacherWithStudentsById(Long id) {
        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Teacher not found"));
        return teacherMapper.toDTO(teacher);
    }
}
