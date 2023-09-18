package com.anibalvillalva.auth.core.entities;


import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Date;

@Getter
@Setter
public class Transaction {

        private double amount;
        private Timestamp timestamp;
        private String description;
        private Account accountFrom;
        private Account accountTo;

        // Constructor
        public Transaction(double amount, Timestamp timestamp, String descripcion, Account accountFrom, Account accountTo) {
            this.amount = amount;
            this.timestamp = timestamp;
            this.description = descripcion;
            this.accountFrom = accountFrom;
            this.accountTo = accountTo;
        }

        @Override
        public String toString() {
            return "TransaccionDTO{" +
                    "monto=" + amount +
                    ", fecha=" + timestamp +
                    ", descripcion='" + description + '\'' +
                    ", cuentaDesde='" + accountFrom + '\'' +
                    ", cuentaHacia='" + accountTo + '\'' +
                    '}';
        }
    }