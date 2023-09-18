package com.anibalvillalva.auth.core.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum TypeAccount {
    CCS(10, "Cuenta Corriente Pesos"),
    CAS(11, "Caja Ahorro Pesos");

    @Getter
    private final Integer code;

    @Getter
    private final String description;

    @Override
    public String toString() {
        return description;
    }
}
