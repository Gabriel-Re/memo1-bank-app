package com.aninfo.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@SuppressWarnings("JpaAttributeTypeInspection")
@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cbu;

    private Double balance;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "cbu")
    private List<Transaction> TransactionList;//Necesito la lista de transacciones

    public Account(){
    }

    public Account(Double balance) {
        this.balance = balance;
        this.TransactionList = new ArrayList<>();
    }

    public Long getCbu() {
        return cbu;
    }

    public void setCbu(Long cbu) {
        this.cbu = cbu;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public List<Transaction> getTransactions() {
        return this.TransactionList;
    }

    public void addTransaction(Transaction _Transaction) {
        this.TransactionList.add(_Transaction);
    }

}
