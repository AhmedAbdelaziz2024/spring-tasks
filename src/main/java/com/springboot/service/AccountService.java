package com.springboot.service;

import com.springboot.dto.AccountDTO;

import java.util.List;

public interface AccountService {
    AccountDTO createAccount(AccountDTO dto);
    AccountDTO getAccount(Long id);
    List<AccountDTO> getAllAccounts();
    AccountDTO updateAccount(Long id, AccountDTO dto);
    void deleteAccount(Long id);
    List<AccountDTO> getAllAccountsWithPosts();
    AccountDTO getAccountWithPosts(Long id);
}
