package com.aninfo.model;

import javax.persistence.*;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Que se genere automaticamente de manera secuencial
    private Long transactionId; //Es un id unico, por eso el @id

    private Long cbu;

    private double amount;

    private TransactionType type;

    public Transaction(){

    }

    public Transaction(TransactionType _TransactionType, Long _ClientCbu, double _Amount) {
        this.type = _TransactionType;
        this.cbu = _ClientCbu;
        this.amount = _Amount;
    }

    public Long getCbuInTransaction() {
        return cbu;
    }

    public double getTransactionAmount() {
        return amount;
    }

    public Long getTransactionId() {
        return transactionId;
    }

}
