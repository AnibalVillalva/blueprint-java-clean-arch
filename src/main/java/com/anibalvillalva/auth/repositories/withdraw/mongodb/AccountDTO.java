package com.anibalvillalva.auth.repositories.withdraw.mongodb;

import com.anibalvillalva.auth.core.entities.Account;
import com.anibalvillalva.auth.core.entities.TypeAccount;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.Date;


@Document("accounts")
public class AccountDTO {
    @Id
    private String _id;

    private Date createdAt;
    private String currency;
    private BigDecimal amount;
    private Long account;

    public Account toEntity() {
        TypeAccount typeAccount;
        switch (currency) {
            case "ARS":
                typeAccount = TypeAccount.CAS;
            default:
                typeAccount = TypeAccount.CCS;
        }
        return Account
                .builder()
                .amount(this.amount)
                .Number(this.account)
                .typeAccount(typeAccount)
                .build();
    }
}
