package com.aninfo.model;

import javax.persistence.*;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Que se genere automaticamente de manera secuencial
    private Long TransactionId; //Es un id unico, por eso el @id

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
