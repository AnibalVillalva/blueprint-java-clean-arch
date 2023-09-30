package com.anibalvillalva.auth.entrypoints.impls;

import com.anibalvillalva.auth.core.entities.Account;
import com.anibalvillalva.auth.core.exceptions.InvalidAccountException;
import com.anibalvillalva.auth.core.usecases.BalanceUseCase;
import com.anibalvillalva.auth.entrypoints.BalanceEntrypoint;
import com.anibalvillalva.auth.entrypoints.dtos.BalanceResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import static java.lang.Long.parseLong;

@RestController
@RequestMapping
@RequiredArgsConstructor
@Slf4j
public class BalanceEntrypointImpl implements BalanceEntrypoint {

    private final BalanceUseCase balanceUseCase;

    @Override
    @GetMapping(path = "/balance/{accountNumber}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BalanceResponse> getBalance( @PathVariable("accountNumber") String accountNumber) {
        log.info("Begin");
        log.info("Account : " + accountNumber);

        final Long acc = parseLong(accountNumber);
        Account account = Account.builder().Number(acc).build();
        Account response;
        try {
            response = balanceUseCase.execute(account);
        } catch (InvalidAccountException e) {
            log.info("Error");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        log.info("Finish");
        return ResponseEntity.ok(new BalanceResponse(response));
    }
}
