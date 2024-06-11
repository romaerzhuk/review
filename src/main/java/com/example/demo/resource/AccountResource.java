package com.example.demo.resource;

import com.example.demo.model.Account;
import com.example.demo.repository.AccountRepository;
import com.example.demo.service.BalanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * AccountResource.
 *
 * @author Author
 */
@RestController
@RequiredArgsConstructor
public class AccountResource {

    private final AccountRepository accountRepository;
    private final BalanceService balanceService;

    @GetMapping(value = "/accounts/add",
            produces = MediaType.APPLICATION_JSON_VALUE)
    Account add(Account account) {
        return accountRepository.save(account);
    }

    @GetMapping(value = "/accounts/{accountNumber}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    List<Account> findByAccountNumber(@PathVariable("accountNumber") String accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber);
    }

    @PutMapping(value = "/accounts/{id}/change",
            produces = MediaType.APPLICATION_JSON_VALUE)
    Account changeBalance(@PathVariable("id") Long id,
                          @RequestParam("diff") Double diff) {
        return balanceService.change(id, diff);
    }
}
