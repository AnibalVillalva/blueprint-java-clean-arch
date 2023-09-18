package com.anibalvillalva.auth.repositories.balance.mock;

import com.anibalvillalva.auth.core.entities.Account;
import com.anibalvillalva.auth.entrypoints.dtos.BalanceResponse;
import com.anibalvillalva.auth.repositories.balance.BalanceRepository;

import java.math.BigDecimal;

public class BalanceImpl implements BalanceRepository {

    public Account execute(Account account) {
        account.setAmount(new BigDecimal("145.02"));
        return account;
    }

}
