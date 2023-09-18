package com.anibalvillalva.auth.core.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class Account {
    private BigDecimal amount;

    private Long Number;

    private TypeAccount typeAccount;
}
