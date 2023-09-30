package com.anibalvillalva.auth.core.entities;


import lombok.Builder;
import lombok.Getter;

import java.sql.Timestamp;

@Getter
@Builder
public class Transaction {

        private Money money;
        private Timestamp timestamp;
        private String description;
        private Account account;

        // Constructor
        public Transaction(Money money, Timestamp timestamp, String descripcion, Account account) {
            this.money = money;
            this.timestamp = timestamp;
            this.description = descripcion;
            this.account = account;
        }

        @Override
        public String toString() {
            return "TransaccionDTO{" +
                    "monto=" + money.getAmount() +
                    ", fecha=" + timestamp +
                    ", descripcion='" + description + '\'' +
                    ", cuentaDesde='" + account + '\'' +
                    '}';
        }
    }