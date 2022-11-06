package com.aninfo.model;

import javax.persistence.*;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long TransactionId;

    private long ClientCbu;

    private double Amount;

    public Transaction(){}

    public Transaction(Long _ClientCbu, double _Amount) {
        this.ClientCbu = _ClientCbu;
        this.Amount = _Amount;
    }

    public Long getTransactionClientCbu() {
        return ClientCbu;
    }

    public double getTransactionAmount() {
        return Amount;
    }

    public Long getTransactionId() {
        return TransactionId;
    }

}
