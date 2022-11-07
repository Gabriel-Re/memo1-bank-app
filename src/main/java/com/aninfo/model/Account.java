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

    private Double amountPromo;

    public Account(){
    }

    public Account(Double balance) {
        this.balance = balance;
        this.TransactionList = new ArrayList<>();
        this.amountPromo = 0d;
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

    public Double getBalancePromo() {
        return this.amountPromo;
    }

    public void addPromoAmount(Double amount) {
        this.amountPromo += amount;
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
