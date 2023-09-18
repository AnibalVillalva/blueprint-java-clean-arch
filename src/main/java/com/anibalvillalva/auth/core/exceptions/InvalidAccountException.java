package com.anibalvillalva.auth.core.exceptions;

import lombok.Getter;

@Getter
public class InvalidAccountException extends Exception {

    private String api;

    private String message;
    public InvalidAccountException() { super(); }


    public InvalidAccountException( final String api, final String message ) {
        super("invalid account");
        this.api = api;
        this.message = message;
    }
}
