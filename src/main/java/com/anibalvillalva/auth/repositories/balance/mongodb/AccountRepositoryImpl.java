package com.anibalvillalva.auth.repositories.balance.mongodb;

import com.anibalvillalva.auth.core.entities.Account;
import com.anibalvillalva.auth.core.exceptions.InvalidAccountException;
import com.anibalvillalva.auth.repositories.balance.BalanceRepository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;


public class AccountRepositoryImpl implements BalanceRepository {

    final MongoTemplate repo;

    public AccountRepositoryImpl(MongoTemplate repo) {
        this.repo = repo;
    }

    @Override
    public Account execute(Account account) throws InvalidAccountException {

        AccountDTO account1 = repo.findOne(
                Query.query(Criteria.where("account").is(account.getNumber())), AccountDTO.class);

        if (account1== null) {
            throw new InvalidAccountException("MongoDB", "Acccount not found");
        }

        return account1.toEntity();
    }
}
