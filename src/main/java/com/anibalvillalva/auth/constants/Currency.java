package com.anibalvillalva.auth.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.Stream;

@Getter
@AllArgsConstructor
public enum Currency {
    ARS("ARS", "032","$", "PESOS", "Argentina"),
    USD("USD", "840","$", "DOLAR", "Estados Unidos");

    private final String code;

    private final String iso;

    private final String symbol;

    private final String description;

    private final String country;

    public static Stream<Currency> stream() {
        return Stream.of(Currency.values());
    }
}
