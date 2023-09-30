package com.anibalvillalva.auth.repositories.withdraw.mock;

import com.anibalvillalva.auth.core.entities.Account;
import com.anibalvillalva.auth.repositories.withdraw.WithdrawRepository;

import java.math.BigDecimal;

public class WithdrawRepositoryMock implements WithdrawRepository {

    public Account execute(Account account, BigDecimal amount) {
        account.setAmount(account.getAmount().subtract(amount));
        return account;
    }

}
