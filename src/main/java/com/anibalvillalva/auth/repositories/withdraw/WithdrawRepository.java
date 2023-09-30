package com.anibalvillalva.auth.repositories.withdraw;

import com.anibalvillalva.auth.core.entities.Account;
import com.anibalvillalva.auth.core.exceptions.InvalidAccountException;

import java.math.BigDecimal;

public interface WithdrawRepository {
    Account execute(Account account, BigDecimal amount) throws InvalidAccountException;
}
