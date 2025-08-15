package com.springboot.controller;

import com.springboot.dto.AccountDTO;
import com.springboot.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private  AccountService accountService;
    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public AccountDTO create(@Valid @RequestBody AccountDTO dto) {
        return accountService.createAccount(dto);
    }

    @GetMapping("/{id}")
    public AccountDTO get(@PathVariable Long id) {
        return accountService.getAccount(id);
    }

    @GetMapping
    public List<AccountDTO> getAll() {
        return accountService.getAllAccounts();
    }

    @PutMapping("/{id}")
    public AccountDTO update(@PathVariable Long id, @Valid @RequestBody AccountDTO dto) {
        return accountService.updateAccount(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        accountService.deleteAccount(id);
    }

    @GetMapping("/accountsWithPosts")
    public List<AccountDTO> getAccountsWithPosts() {
        return accountService.getAllAccountsWithPosts();
    }

    @GetMapping("/accountWithPosts/{id}")
    public AccountDTO getAccountWithPosts(@PathVariable Long id) {
        return accountService.getAccountWithPosts(id);
    }
}
