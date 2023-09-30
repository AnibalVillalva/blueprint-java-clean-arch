package com.anibalvillalva.auth.core.usecases.impl;

import com.anibalvillalva.auth.constants.ValidationAccountStatus;
import com.anibalvillalva.auth.core.entities.Transaction;
import com.anibalvillalva.auth.core.exceptions.InvalidAccountException;
import com.anibalvillalva.auth.core.usecases.ValidationTransacionUseCase;

import java.util.Objects;

public class ValidateAccountTo implements ValidationTransacionUseCase {

    @Override
    public ValidationAccountStatus execute(Transaction tx) throws InvalidAccountException {

        if (!Objects.equals(tx.getAccount().getTypeAccount().getCurrency(), tx.getMoney().getCurrency())) {
            throw new InvalidAccountException("API", ValidationAccountStatus.INVALID_CURRENCY.toString());
        }

        return ValidationAccountStatus.OK;
    }
}
