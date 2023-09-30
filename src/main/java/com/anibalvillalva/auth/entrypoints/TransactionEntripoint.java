package com.anibalvillalva.auth.entrypoints;

import com.anibalvillalva.auth.entrypoints.dtos.BalanceResponse;
import com.anibalvillalva.auth.entrypoints.dtos.TransactionRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestBody;

public interface TransactionEntripoint {
    public ResponseEntity<BalanceResponse> doTransaction(@RequestBody final TransactionRequest request,
                                                         final Errors result);
}
