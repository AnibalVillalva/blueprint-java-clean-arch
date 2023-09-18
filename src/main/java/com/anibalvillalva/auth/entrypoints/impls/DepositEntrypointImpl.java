package com.anibalvillalva.auth.entrypoints.impls;

import com.anibalvillalva.auth.core.entities.Account;
//import com.anibalvillalva.auth.core.usecases.DepositUseCase;
import com.anibalvillalva.auth.entrypoints.dtos.BalanceResponse;
import com.anibalvillalva.auth.entrypoints.dtos.TransactionRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping
@RequiredArgsConstructor
@Slf4j
public class DepositEntrypointImpl {

//    private final DepositUseCase useCase;

  //  @Override
    @PostMapping(path = "/deposit", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BalanceResponse> doTransaction(@Valid @RequestBody final TransactionRequest request,
                                                         final Errors result) {
        log.info("Begin");
        log.info(String.valueOf(request));

        Account account = request.toAccount();
//        Account response = useCase.execute(account);


        log.info("Finish");
        return ResponseEntity.ok(new BalanceResponse(account));
    }
}
