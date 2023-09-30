package com.anibalvillalva.auth.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ValidationAccountStatus {
    OK("000", "OK."),
    ACCOUNT_NOT_FOUND("001", "Account not found"),
    INVALID_CURRENCY("002", "Invalid currency."),
    INVALID_DAILY_LIMIT("003", "Exceeds daily limit.");

    private final String error;

    private final String description;

    @Override
    public String toString() {
        return description;
    }
}
