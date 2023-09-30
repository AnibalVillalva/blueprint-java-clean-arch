package com.anibalvillalva.auth.core.usecases;

import com.anibalvillalva.auth.core.entities.Account;
import com.anibalvillalva.auth.core.entities.Transaction;

public interface TransactionUseCase {
    Account execute(Transaction tx) throws Exception;
}
