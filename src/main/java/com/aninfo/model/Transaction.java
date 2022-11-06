package com.aninfo.model;

import javax.persistence.*;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Que se genere automaticamente de manera secuencial
    private Long transactionId; //Es un id unico, por eso el @id

    private long clientCbu;

    private double amount;

    public Transaction(){}

    public Transaction(Long _ClientCbu, double _Amount) {
        this.clientCbu = _ClientCbu;
        this.amount = _Amount;
    }

    public Long getTransactionClientCbu() {
        return clientCbu;
    }

    public double getTransactionAmount() {
        return amount;
    }

    public Long getTransactionId() {
        return transactionId;
    }

}
