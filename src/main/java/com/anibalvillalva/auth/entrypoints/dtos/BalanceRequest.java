package com.anibalvillalva.auth.entrypoints.dtos;

import com.anibalvillalva.auth.core.entities.Account;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BalanceRequest {
    private Long account;

    public Account toAccount() {
        return Account.builder().Number(account).build();
    }
}
