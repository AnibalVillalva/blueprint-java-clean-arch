package com.anibalvillalva.auth.repositories.balance.mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface AccountRepository extends MongoRepository<AccountDTO, Long> {
    @Query("{account:'?0'}")
    AccountDTO findItemByAccount(Long account);
}
