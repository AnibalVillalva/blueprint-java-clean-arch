package com.anibalvillalva.auth.entrypoints.dtos;

import com.anibalvillalva.auth.core.entities.Account;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@JsonIgnoreProperties(
        ignoreUnknown = true
)
public class BalanceResponse {
    @JsonProperty("account")
    private Long account;

    @JsonProperty("amount")
    private BigDecimal amount;

    @JsonProperty("currency")
    private String currency;

    public BalanceResponse(Account account){
        this.account = account.getNumber();
        this.amount = account.getAmount();
        this.currency = "ARS";

    }
}
