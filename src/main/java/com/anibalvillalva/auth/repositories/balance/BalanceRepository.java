package com.anibalvillalva.auth.repositories.balance;

import com.anibalvillalva.auth.core.entities.Account;
import com.anibalvillalva.auth.core.exceptions.InvalidAccountException;

public interface BalanceRepository {
    Account execute(Account account) throws InvalidAccountException;

}
