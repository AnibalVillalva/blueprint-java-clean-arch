package com.anibalvillalva.auth.core.usecases.impl;

import com.anibalvillalva.auth.core.entities.Account;
import com.anibalvillalva.auth.core.usecases.BalanceUseCase;
import com.anibalvillalva.auth.repositories.balance.BalanceRepository;

public class BalanceUseCaseImpl implements BalanceUseCase {

    private final BalanceRepository repository;

    public BalanceUseCaseImpl(BalanceRepository repository) {
        this.repository = repository;
    }
    @Override
    public Account execute(Account account) {

        return repository.execute(account);
    }
}