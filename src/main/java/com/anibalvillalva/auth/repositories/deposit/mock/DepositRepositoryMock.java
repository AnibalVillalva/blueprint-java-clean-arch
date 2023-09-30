package com.anibalvillalva.auth.repositories.deposit.mock;

import com.anibalvillalva.auth.core.entities.Account;
import com.anibalvillalva.auth.core.exceptions.InvalidAccountException;
import com.anibalvillalva.auth.repositories.deposit.DepositRepository;

import java.math.BigDecimal;

public class DepositRepositoryMock implements DepositRepository {

    public Account execute(Account account, BigDecimal amount) throws Exception {
        if (account.getNumber() == 123L) {
            throw new InvalidAccountException("Mock Deposit", "Account not found");
        }
        account.setAmount(account.getAmount().add(amount));
        return account;
    }

}
