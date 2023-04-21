package com.example.demo.service;

import com.example.demo.model.Account;
import com.example.demo.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * BalanceService.
 *
 * @author Author
 */
@Service
public class BalanceService {

    @Autowired
    AccountRepository accountRepository;

    public Account change(Long id, Double diff) {
        Account account = accountRepository.getOne(id);
        account.setAmount(account.getAmount() + diff);
        return accountRepository.save(account);
    }
}
