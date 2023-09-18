package com.anibalvillalva.auth.config;

import com.anibalvillalva.auth.core.usecases.BalanceUseCase;
import com.anibalvillalva.auth.core.usecases.impl.BalanceUseCaseImpl;
import com.anibalvillalva.auth.entrypoints.BalanceEntrypoint;
import com.anibalvillalva.auth.entrypoints.TransactionEntripoint;
import com.anibalvillalva.auth.repositories.balance.BalanceRepository;
import com.anibalvillalva.auth.repositories.balance.mock.BalanceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackageClasses = {BalanceEntrypoint.class, TransactionEntripoint.class})
@Configuration
public class Injector {

    @Bean
    public BalanceRepository createBalanceRepository() {
        return new BalanceImpl();
    }
    @Bean
    public BalanceUseCase createBalanceUseCase() {
        return new BalanceUseCaseImpl( createBalanceRepository());
    }


}
