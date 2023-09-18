package com.anibalvillalva.auth.repositories.deposit;

import com.anibalvillalva.auth.core.entities.Account;

import java.math.BigDecimal;

public interface DepositRepository {
    Account execute(com.anibalvillalva.auth.core.entities.Account account, BigDecimal amount) throws Exception;
}
