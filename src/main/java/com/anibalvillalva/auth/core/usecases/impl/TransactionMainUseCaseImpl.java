package com.anibalvillalva.auth.core.usecases.impl;

import com.anibalvillalva.auth.core.entities.Account;
import com.anibalvillalva.auth.core.entities.Transaction;
import com.anibalvillalva.auth.core.usecases.TransactionUseCase;
import com.anibalvillalva.auth.repositories.balance.BalanceRepository;

public class TransactionMainUseCaseImpl implements TransactionUseCase {
    //private final ValidateAccountFrom validateAccountFrom;

    //private final ValidateAccountTo validateAccountTo;


    public TransactionMainUseCaseImpl(BalanceRepository repository) {
        //this.repository = repository;
    }
    @Override
    public Transaction execute(Transaction tx) {

        return tx; // repository.execute(tx);
    }
}
