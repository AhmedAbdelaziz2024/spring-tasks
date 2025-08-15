package com.springboot.service.serviceImpl;

import com.springboot.dto.EmailDTO;
import com.springboot.mapper.EmailMapper;
import com.springboot.model.Email;
import com.springboot.model.Employee;
import com.springboot.repository.EmailRepo;
import com.springboot.repository.EmployeeRepo;
import com.springboot.service.EmailService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailServiceImpl implements EmailService {

    private  EmailRepo emailRepository;
    private  EmployeeRepo employeeRepo;
    private  EmailMapper emailMapper;

    @Autowired
    public EmailServiceImpl(EmailRepo emailRepository, EmployeeRepo employeeRepo, EmailMapper emailMapper) {
        this.emailRepository = emailRepository;
        this.employeeRepo = employeeRepo;
        this.emailMapper = emailMapper;
    }

    @Override
    public EmailDTO create(EmailDTO dto) {
        Email entity = emailMapper.toEntity(dto);

        if (dto.getEmployeeId() != null) {
            Employee employee = employeeRepo.findById(dto.getEmployeeId())
                    .orElseThrow(() -> new EntityNotFoundException("Employee not found"));
            entity.setEmployee(employee);
        }

        return emailMapper.toDto(emailRepository.save(entity));
    }

    @Override
    public EmailDTO update(Long id, EmailDTO dto) {
        Email existing = emailRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Email not found"));

        existing.setName(dto.getName());
        existing.setContent(dto.getContent());

        return emailMapper.toDto(emailRepository.save(existing));
    }

    @Override
    public void delete(Long id) {
        emailRepository.deleteById(id);
    }

    @Override
    public List<EmailDTO> getAll() {
        return emailMapper.toDtoList(emailRepository.findAll());
    }

    @Override
    public List<EmailDTO> getByName(String name) {
        return emailMapper.toDtoList(emailRepository.findByName(name));
    }

    @Override
    public List<EmailDTO> getByNames(List<String> names) {
        return emailMapper.toDtoList(emailRepository.findByNameIn(names));
    }

    @Override
    public List<EmailDTO> getByContent(String content) {
        return emailMapper.toDtoList(emailRepository.findByContent(content));
    }
}
