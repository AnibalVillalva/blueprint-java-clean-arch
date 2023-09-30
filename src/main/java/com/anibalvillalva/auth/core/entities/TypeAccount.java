package com.anibalvillalva.auth.core.entities;

import com.anibalvillalva.auth.constants.Currency;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TypeAccount {
    CCS(10, Currency.ARS,"Cuenta Corriente Pesos"),
    CAS(11, Currency.ARS, "Caja Ahorro Pesos");

    private final Integer code;

    private final Currency currency;

    private final String description;

    @Override
    public String toString() {
        return description;
    }

}
