package com.anibalvillalva.auth.core.usecases;

import com.anibalvillalva.auth.core.entities.Account;
import com.anibalvillalva.auth.core.exceptions.InvalidAccountException;
import com.anibalvillalva.auth.entrypoints.dtos.BalanceResponse;

public interface BalanceUseCase {
    Account execute(Account account) throws InvalidAccountException;
}
