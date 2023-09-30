package com.anibalvillalva.auth.core.usecases;

import com.anibalvillalva.auth.constants.ValidationAccountStatus;
import com.anibalvillalva.auth.core.entities.Transaction;
import com.anibalvillalva.auth.core.exceptions.InvalidAccountException;

public interface ValidationTransacionUseCase {

    ValidationAccountStatus execute(Transaction tx) throws InvalidAccountException;
}
