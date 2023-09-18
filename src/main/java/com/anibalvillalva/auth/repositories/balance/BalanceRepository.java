package com.anibalvillalva.auth.repositories.balance;

import com.anibalvillalva.auth.core.entities.Account;

public interface BalanceRepository {
    Account execute(Account account);
}
