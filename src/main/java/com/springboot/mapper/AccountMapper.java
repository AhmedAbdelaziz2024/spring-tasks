package com.springboot.mapper;

import com.springboot.dto.AccountDTO;
import com.springboot.model.Account;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    AccountDTO toDTO(Account account);
    Account toEntity(AccountDTO dto);
}
