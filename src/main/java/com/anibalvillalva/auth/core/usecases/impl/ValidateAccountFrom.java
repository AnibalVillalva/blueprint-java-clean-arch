package com.anibalvillalva.auth.core.usecases.impl;

import com.anibalvillalva.auth.core.entities.Account;
import com.anibalvillalva.auth.repositories.balance.BalanceRepository;

public class ValidateAccountFrom implements BalanceRepository{
    private final BalanceRepository repository;

    public ValidateAccountFrom(BalanceRepository repository) {
        this.repository = repository;
    }

    @Override
    public Account execute(Account account) {

        return repository.execute(account);
    }
}
