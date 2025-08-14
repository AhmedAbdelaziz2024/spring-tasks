package com.springboot.service;

import com.springboot.dto.EmailDTO;

import java.util.List;

public interface EmailService {

    EmailDTO create(EmailDTO dto);

    EmailDTO update(Long id, EmailDTO dto);

    void delete(Long id);

    List<EmailDTO> getAll();

    List<EmailDTO> getByName(String name);

    List<EmailDTO> getByNames(List<String> names);

    List<EmailDTO> getByContent(String content);
}
