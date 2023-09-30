package com.anibalvillalva.auth.core.usecases.impl;

import com.anibalvillalva.auth.constants.ValidationAccountStatus;
import com.anibalvillalva.auth.core.entities.Account;
import com.anibalvillalva.auth.core.entities.Transaction;
import com.anibalvillalva.auth.core.exceptions.InvalidAccountException;
import com.anibalvillalva.auth.core.usecases.BalanceUseCase;
import com.anibalvillalva.auth.core.usecases.TransactionUseCase;
import com.anibalvillalva.auth.core.usecases.ValidationTransacionUseCase;
import com.anibalvillalva.auth.repositories.withdraw.WithdrawRepository;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Objects;


@Qualifier("withdraw")
public class WithdrawCaseImpl implements TransactionUseCase {
    private final BalanceUseCase balance;

    private final ValidationTransacionUseCase validate;

    private final WithdrawRepository withdrawRepository;

    public WithdrawCaseImpl(BalanceUseCase balance, ValidationTransacionUseCase validate,
                            WithdrawRepository withdrawRepository) {
        this.balance = balance;
        this.validate = validate;
        this.withdrawRepository = withdrawRepository;
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

        return withdrawRepository.execute(result.getAccount(),result.getMoney().getAmount());

    }
}
