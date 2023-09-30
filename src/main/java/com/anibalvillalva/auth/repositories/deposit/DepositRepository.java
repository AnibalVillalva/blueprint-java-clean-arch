package com.anibalvillalva.auth.repositories.deposit;

import com.anibalvillalva.auth.core.entities.Account;

import java.math.BigDecimal;

public interface DepositRepository {
    Account execute(Account account, BigDecimal amount) throws Exception;
}
