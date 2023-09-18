package com.anibalvillalva.auth.core.usecases;

import com.anibalvillalva.auth.core.entities.Transaction;

public interface TransactionUseCase {
    public Transaction execute(Transaction tx);
}
