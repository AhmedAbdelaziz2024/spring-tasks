package com.springboot.controller;

import com.springboot.dto.EmailDTO;
import com.springboot.service.EmailService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/emails")
public class EmailController {

    private EmailService emailService;
    @Autowired
    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping
    public ResponseEntity<EmailDTO> create(@Valid @RequestBody EmailDTO dto) {
        return ResponseEntity.status(201).body(emailService.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmailDTO> update(@PathVariable Long id, @Valid @RequestBody EmailDTO dto) {
        return ResponseEntity.ok(emailService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        emailService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<EmailDTO>> getAll() {
        return ResponseEntity.ok(emailService.getAll());
    }

    @GetMapping("/by-name/{name}")
    public ResponseEntity<List<EmailDTO>> getByName(@PathVariable String name) {
        return ResponseEntity.ok(emailService.getByName(name));
    }

    @PostMapping("/by-names")
    public ResponseEntity<List<EmailDTO>> getByNames(@RequestBody List<String> names) {
        return ResponseEntity.ok(emailService.getByNames(names));
    }

    @GetMapping("/by-content/{content}")
    public ResponseEntity<List<EmailDTO>> getByContent(@PathVariable String content) {
        return ResponseEntity.ok(emailService.getByContent(content));
    }
}
