package com.anibalvillalva.auth.repositories.withdraw.mongodb;

import com.anibalvillalva.auth.core.entities.Account;
import com.anibalvillalva.auth.core.exceptions.InvalidAccountException;
import com.anibalvillalva.auth.repositories.deposit.mongodb.AccountDTO;
import com.anibalvillalva.auth.repositories.withdraw.WithdrawRepository;
import com.mongodb.client.result.UpdateResult;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.math.BigDecimal;


public class WithdrawRepositoryImpl implements WithdrawRepository {

    final MongoTemplate repo;

    public WithdrawRepositoryImpl(MongoTemplate repo) {
        this.repo = repo;
    }

    @Override
    public Account execute(Account account, BigDecimal amount) throws InvalidAccountException {

        final Query query = Query.query(Criteria.where("account").is(account.getNumber()));

        UpdateResult result = repo.updateFirst( query,
                Update.update("amount", account.getAmount().subtract(amount)),
                com.anibalvillalva.auth.repositories.deposit.mongodb.AccountDTO.class);

        if (result== null) {
            throw new InvalidAccountException("MongoDB", "Acccount not found");
        }

        com.anibalvillalva.auth.repositories.deposit.mongodb.AccountDTO account1 = repo.findOne(Query.query(Criteria.where("account").is(account.getNumber())), AccountDTO.class);
        return account1.toEntity();
    }
}
