package com.anibalvillalva.auth.core.usecases.impl;

import com.anibalvillalva.auth.constants.ValidationAccountStatus;
import com.anibalvillalva.auth.core.entities.Account;
import com.anibalvillalva.auth.core.entities.Transaction;
import com.anibalvillalva.auth.core.exceptions.InvalidAccountException;
import com.anibalvillalva.auth.core.usecases.BalanceUseCase;
import com.anibalvillalva.auth.core.usecases.TransactionUseCase;
import com.anibalvillalva.auth.core.usecases.ValidationTransacionUseCase;
import com.anibalvillalva.auth.repositories.deposit.DepositRepository;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Objects;

@Qualifier("withdraw")
public class DepositUseCaseImpl implements TransactionUseCase {

    private final BalanceUseCase balance;

    private final ValidationTransacionUseCase validate;

    private final DepositRepository deposit;

    public DepositUseCaseImpl(BalanceUseCase balance, ValidationTransacionUseCase validate,
                              DepositRepository deposit) {
        this.balance = balance;
        this.validate = validate;
        this.deposit = deposit;
    }

    @Override
    public Account execute(final Transaction tx) throws Exception {
        final Account account = balance.execute(tx.getAccount());
        final Transaction result = Transaction.builder()
                .account(account)
                .money(tx.getMoney())
                .description(tx.getDescription())
                .build();

        final ValidationAccountStatus validationAccountStatus = validate.execute(result);
        if(!Objects.equals(validationAccountStatus, ValidationAccountStatus.OK)) {
            throw new InvalidAccountException("AUTH", validationAccountStatus.toString());
        }

        return deposit.execute(result.getAccount(),result.getMoney().getAmount());

    }
}
