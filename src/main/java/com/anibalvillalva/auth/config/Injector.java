package com.anibalvillalva.auth.config;

import com.anibalvillalva.auth.core.usecases.BalanceUseCase;
import com.anibalvillalva.auth.core.usecases.ValidationTransacionUseCase;
import com.anibalvillalva.auth.core.usecases.impl.*;
import com.anibalvillalva.auth.entrypoints.BalanceEntrypoint;
import com.anibalvillalva.auth.entrypoints.TransactionEntripoint;
import com.anibalvillalva.auth.repositories.balance.BalanceRepository;
import com.anibalvillalva.auth.repositories.balance.mock.BalanceImpl;
import com.anibalvillalva.auth.repositories.balance.mongodb.AccountRepositoryImpl;
import com.anibalvillalva.auth.repositories.deposit.DepositRepository;
import com.anibalvillalva.auth.repositories.deposit.mock.DepositRepositoryMock;
import com.anibalvillalva.auth.repositories.deposit.mongodb.DepositRepositoryImpl;
import com.anibalvillalva.auth.repositories.withdraw.WithdrawRepository;
import com.anibalvillalva.auth.repositories.withdraw.mock.WithdrawRepositoryMock;
import com.anibalvillalva.auth.repositories.withdraw.mongodb.WithdrawRepositoryImpl;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@ComponentScan(basePackageClasses = {BalanceEntrypoint.class, TransactionEntripoint.class})
@EnableMongoRepositories
@Configuration
public class Injector {

    /* CLIENTS */

    @Bean
    public MongoClient mongo() {
        ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017");
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();

        return MongoClients.create(mongoClientSettings);
    }

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongo(), "test-clean");
    }

    /* REPOSITORIES */
    @Bean
    public BalanceRepository createBalanceMock() {
        return new BalanceImpl();
    }

    @Bean
    public DepositRepository createDepositMock() {
        return new DepositRepositoryMock();
    }

    @Bean
    public WithdrawRepository createWithdrawMock() {
        return new WithdrawRepositoryMock();
    }

    @Bean
    public BalanceRepository createBalanceMongo() throws Exception {
        return new AccountRepositoryImpl(mongoTemplate());
    }

    @Bean
    public DepositRepository createDepositRepositoryMongo() throws Exception {
        return new DepositRepositoryImpl(mongoTemplate());
    }

    @Bean
    public WithdrawRepository createWithdrawRepositoryMongo() throws Exception {
        return new WithdrawRepositoryImpl(mongoTemplate());
    }


    /* USE CASES */
    @Bean
    public BalanceUseCase createBalanceUseCase() throws Exception {
        //return new BalanceUseCaseImpl( createBalanceMock());
        return new BalanceUseCaseImpl(createBalanceMongo());
    }

    @Bean
    public ValidationTransacionUseCase createValidateAccountFrom() {
        return new ValidateAccountFrom();
    }

    @Bean
    public ValidationTransacionUseCase createValidateAccountTo() {
        return new ValidateAccountTo();
    }

    @Bean
    public DepositRepository createDepositRepository() {
        return new DepositRepositoryMock();
    }

    @Bean
    public DepositUseCaseImpl createDepositUseCaseImpl() throws Exception {
        return new DepositUseCaseImpl(createBalanceUseCase(), createValidateAccountTo(), createDepositRepositoryMongo());
    }


    @Bean
    public WithdrawCaseImpl createWithdrawUseCaseImpl() throws Exception {
        return new WithdrawCaseImpl(createBalanceUseCase(), createValidateAccountFrom(), createWithdrawRepositoryMongo());
    }



}
