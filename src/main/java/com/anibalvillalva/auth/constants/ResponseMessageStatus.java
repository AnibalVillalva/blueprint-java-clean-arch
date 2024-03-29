package com.anibalvillalva.auth.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum ResponseMessageStatus {

    REQUEST_SAVED("200", "Request Saved"),
    VALIDATION_ERROR("400", "Error");

    private final String status;

    private final String description;

    @Override
    public String toString() {
        return description;
    }
}
