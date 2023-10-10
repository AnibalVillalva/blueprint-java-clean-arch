package com.anibalvillalva.auh.entrypoints;

import com.anibalvillalva.auth.config.Application;
import com.anibalvillalva.auth.core.entities.Account;
import com.anibalvillalva.auth.core.entities.TypeAccount;
import com.anibalvillalva.auth.repositories.balance.BalanceRepository;
import com.anibalvillalva.auth.repositories.deposit.DepositRepository;
import com.anibalvillalva.auth.repositories.withdraw.WithdrawRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;


@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BalanceEntrypointTest extends AbstractController {


    @MockBean
    private BalanceRepository repo;

    @MockBean
    private DepositRepository repo1;

    @MockBean
    private WithdrawRepository repo2;

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
    private <T> ResponseEntity <T> executeGet( final String url, final Class<T> clazz) {
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
        final ResponseEntity<String> response = executeGet(url, String.class);

        assertEquals(HttpStatus.OK.value(), response.getStatusCode().value(),"Should be 200");
        //assertEquals(12, Objects.requireNonNull(response.getBody()).getAccount(), "Error on account");
        //assertEquals("ARS", response.getBody().getCurrency(), "Error on currency");
        //assertEquals("123.05", response.getBody().getAmount().toString(), "Error on amount");

    }
}
