package com.anibalvillalva.auth.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum ResponseMessageStatus {

    REQUEST_SAVED("200", "Request Saved"),
    VALIDATION_ERROR("400", "Error");

    @Getter
    private final String status;

    @Getter
    private final String description;

    @Override
    public String toString() {
        return description;
    }
}
