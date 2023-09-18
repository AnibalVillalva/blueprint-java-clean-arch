package com.anibalvillalva.auth.entrypoints;

import com.anibalvillalva.auth.entrypoints.dtos.BalanceRequest;
import com.anibalvillalva.auth.entrypoints.dtos.BalanceResponse;
import com.anibalvillalva.auth.entrypoints.dtos.ResponseModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

public interface BalanceEntrypoint {

    @GetMapping(path = "/balance",
            produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<BalanceResponse> getBalance( @PathVariable String accountNumber);
}
