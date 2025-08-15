package com.springboot.service.serviceImpl;

import com.springboot.dto.EmployeeDTO;
import com.springboot.mapper.EmployeeMapper;
import com.springboot.model.Employee;
import com.springboot.repository.EmployeeRepo;
import com.springboot.service.EmployeeService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private  EmployeeRepo employeeRepository;
    private EmployeeMapper employeeMapper;
    @Autowired
    public EmployeeServiceImpl(EmployeeRepo employeeRepository, EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
    }

    @Override
    public EmployeeDTO create(EmployeeDTO dto) {
        Employee entity = employeeMapper.toEntity(dto);

        if (entity.getEmails() != null) {
            entity.getEmails().forEach(email -> email.setEmployee(entity));
        }
        Employee saved = employeeRepository.save(entity);
        return employeeMapper.toDto(saved);
    }

    @Override
    public EmployeeDTO update(Long id, EmployeeDTO dto) {
        Employee existing = employeeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found"));

        existing.setName(dto.getName());
        existing.setAge(dto.getAge());
        existing.setSalary(dto.getSalary());

        return employeeMapper.toDto(employeeRepository.save(existing));
    }

    @Override
    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<EmployeeDTO> getAll() {
        return employeeMapper.toDtoList(employeeRepository.findAll());
    }

    @Override
    public EmployeeDTO getById(Long id) {
        return employeeMapper.toDto(employeeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found")));
    }

    @Override
    public List<EmployeeDTO> getByIds(List<Long> ids) {
        return employeeMapper.toDtoList(employeeRepository.findAllById(ids));
    }

    @Override
    public List<EmployeeDTO> getByNames(List<String> names) {
        return employeeMapper.toDtoList(employeeRepository.findByNameIn(names));
    }
}


