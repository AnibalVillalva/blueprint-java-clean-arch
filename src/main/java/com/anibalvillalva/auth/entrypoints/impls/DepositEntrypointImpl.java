package com.anibalvillalva.auth.entrypoints.impls;

import com.anibalvillalva.auth.core.entities.Account;
import com.anibalvillalva.auth.core.entities.Transaction;
import com.anibalvillalva.auth.core.usecases.impl.DepositUseCaseImpl;
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
public class DepositEntrypointImpl {

    private final DepositUseCaseImpl useCase;

  //  @Override
    @PostMapping(path = "/deposit", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity doTransaction(@RequestBody final TransactionRequest request,
                                                         final Errors result) throws Exception {
        log.info("Begin Deposit");
        log.info(String.valueOf(request));

        Transaction tx = request.toTransaction();

        Account response = useCase.execute(tx);

        log.info("Finish Deposit");
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new BalanceResponse(response));
    }

}
