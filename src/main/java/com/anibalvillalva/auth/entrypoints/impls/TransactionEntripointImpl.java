package com.anibalvillalva.auth.entrypoints.impls;

import com.anibalvillalva.auth.core.entities.Account;
import com.anibalvillalva.auth.entrypoints.TransactionEntripoint;
import com.anibalvillalva.auth.entrypoints.dtos.BalanceResponse;
import com.anibalvillalva.auth.entrypoints.dtos.TransactionRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
@Slf4j
public class TransactionEntripointImpl implements TransactionEntripoint {

    //private final TransactionUseCase useCase;

    @Override
    @PostMapping(path = "/transaction", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity doTransaction(@RequestBody final TransactionRequest request,
                                                      final Errors result) {
        log.info("Begin");
        log.info(String.valueOf(request));

        Account account = request.toAccount();
        //Account response = useCase.execute(account);


        log.info("Finish");
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new BalanceResponse(account));
    }
}
