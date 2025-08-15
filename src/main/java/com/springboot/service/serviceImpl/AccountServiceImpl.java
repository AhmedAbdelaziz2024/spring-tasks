package com.springboot.service.serviceImpl;

import com.springboot.dto.AccountDTO;
import com.springboot.mapper.AccountMapper;
import com.springboot.model.Account;
import com.springboot.repository.AccountRepo;
import com.springboot.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepo accountRepository;
    private AccountMapper accountMapper;
    @Autowired
    public AccountServiceImpl(AccountRepo accountRepository, AccountMapper accountMapper) {
        this.accountRepository = accountRepository;
        this.accountMapper = accountMapper;
    }

    @Override
    public AccountDTO createAccount(AccountDTO dto) {
        Account account = accountMapper.toEntity(dto);
        return accountMapper.toDTO(accountRepository.save(account));
    }

    @Override
    public AccountDTO getAccount(Long id) {
        return accountRepository.findById(id)
                .map(accountMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Account not found"));
    }

    @Override
    public List<AccountDTO> getAllAccounts() {
        return accountRepository.findAll()
                .stream()
                .map(accountMapper::toDTO)
                .toList();
    }

    @Override
    public AccountDTO updateAccount(Long id, AccountDTO dto) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found"));
        account.setName(dto.getName());
        account.setAge(dto.getAge());
        account.setPassword(dto.getPassword());
        return accountMapper.toDTO(accountRepository.save(account));
    }

    @Override
    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }

    @Override
    public List<AccountDTO> getAllAccountsWithPosts() {
        return getAllAccounts();
    }

    @Override
    public AccountDTO getAccountWithPosts(Long id) {
        return getAccount(id);
    }
}
