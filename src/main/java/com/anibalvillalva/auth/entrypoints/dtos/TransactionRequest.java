package com.anibalvillalva.auth.entrypoints.dtos;

import com.anibalvillalva.auth.constants.Currency;
import com.anibalvillalva.auth.core.entities.Account;
import com.anibalvillalva.auth.core.entities.Money;
import com.anibalvillalva.auth.core.entities.Transaction;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransactionRequest {
    @JsonProperty("account")
    private Long account;

    @JsonProperty("amount")
    private BigDecimal amount;

    @JsonProperty("currency")
    private String currency;

    public Account toAccount() {
        return Account.builder().Number(account).build();
    }

    public Transaction toTransaction() {
        final Currency currency = Currency.stream().filter(c ->c.getCode().equals(this.currency)).findFirst().get();

        return Transaction.builder()
                .account(Account.builder().Number(account).build())
                .money(Money.builder().amount(this.amount).currency(currency).build())
                .build();
    }
}
