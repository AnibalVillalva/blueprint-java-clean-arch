package com.anibalvillalva.auth.repositories.withdraw;

import com.anibalvillalva.auth.core.entities.Account;

import java.math.BigDecimal;

public interface WithdrawRepository {
    Account execute(Account account, BigDecimal amount);
}
