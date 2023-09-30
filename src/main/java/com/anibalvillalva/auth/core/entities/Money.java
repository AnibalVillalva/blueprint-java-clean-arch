package com.anibalvillalva.auth.core.entities;

import com.anibalvillalva.auth.constants.Currency;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;


@Getter
@Builder
public class Money {
    private BigDecimal amount;

    private Currency currency;
}
