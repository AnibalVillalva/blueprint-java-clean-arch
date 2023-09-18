package com.anibalvillalva.auh.entrypoints;

import com.anibalvillalva.auth.config.Application;
import com.anibalvillalva.auth.core.entities.Account;
import com.anibalvillalva.auth.core.entities.TypeAccount;
import com.anibalvillalva.auth.core.usecases.BalanceUseCase;
import com.anibalvillalva.auth.core.usecases.impl.BalanceUseCaseImpl;
import com.anibalvillalva.auth.entrypoints.BalanceEntrypoint;
import com.anibalvillalva.auth.entrypoints.dtos.BalanceResponse;
import com.anibalvillalva.auth.entrypoints.impls.BalanceEntrypointImpl;
import com.anibalvillalva.auth.repositories.balance.BalanceRepository;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;


@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BalanceEntrypointTest extends AbstractController {


    @MockBean
    private BalanceRepository repo;
/*
    @MockBean
    private BalanceUseCase useCase;

    @Autowired
    private BalanceEntrypoint entrypoint;
*/

    @Autowired
    private TestRestTemplate restTemplate;

/*    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
        this.useCase = new BalanceUseCaseImpl(repo);
        entrypoint = new BalanceEntrypointImpl(useCase);
    }*/

    // TEST UTILS
    public static HttpEntity getEntity() {
        HttpHeaders headers = new HttpHeaders();
        return new HttpEntity<>("body");
    }
    private <T> ResponseEntity <T>  executeGet( final String url, final Class<T> clazz) {
        return this.restTemplate.exchange(url, HttpMethod.GET, getEntity(), clazz);
    }
    @Test
    public void testEntrypoint() throws Exception {
        final Account mockAccount = Account.builder().Number(123L).build();
        Mockito.when(repo.execute(any()))
                .thenReturn(
                        Account.builder().Number(12L).typeAccount(TypeAccount.CAS).amount(new BigDecimal("123.05")).build()
                );
        final String url = "/balance/123";
        final ResponseEntity<BalanceResponse> response = executeGet(url, BalanceResponse.class);

        assertEquals(HttpStatus.OK.value(), response.getStatusCode().value(),"Should be 200");
        assertEquals(12, Objects.requireNonNull(response.getBody()).getAccount(), "Error on account");
        assertEquals("ARS", response.getBody().getCurrency(), "Error on currency");
        assertEquals("123.05", response.getBody().getAmount().toString(), "Error on amount");

    }
}
