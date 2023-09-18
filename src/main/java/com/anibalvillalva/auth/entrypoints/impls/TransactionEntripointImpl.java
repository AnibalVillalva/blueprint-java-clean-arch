package com.anibalvillalva.auth.entrypoints.impls;

import com.anibalvillalva.auth.core.entities.Account;
import com.anibalvillalva.auth.core.usecases.TransactionUseCase;
import com.anibalvillalva.auth.entrypoints.TransactionEntripoint;
import com.anibalvillalva.auth.entrypoints.dtos.TransactionRequest;
import com.anibalvillalva.auth.entrypoints.dtos.BalanceResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping
@RequiredArgsConstructor
@Slf4j
public class TransactionEntripointImpl implements TransactionEntripoint {

    //private final TransactionUseCase useCase;

    @Override
    @PostMapping(path = "/transaction", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BalanceResponse> doTransaction(@Valid @RequestBody final TransactionRequest request,
                                                      final Errors result) {
        log.info("Begin");
        log.info(String.valueOf(request));

        Account account = request.toAccount();
        //Account response = useCase.execute(account);


        log.info("Finish");
        return ResponseEntity.ok(new BalanceResponse(account));
    }
}
