package com.anibalvillalva.auth.entrypoints;

import com.anibalvillalva.auth.entrypoints.dtos.BalanceResponse;
import com.anibalvillalva.auth.entrypoints.dtos.TransactionRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

public interface TransactionEntripoint {
    public ResponseEntity<BalanceResponse> doTransaction(@Valid @RequestBody final TransactionRequest request,
                                                         final Errors result);
}
