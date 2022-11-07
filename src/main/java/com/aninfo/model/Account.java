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

    private Double amountPromoToClaim;

    public Account(){
        this.balance = 0d;
        this.TransactionList = new ArrayList<>();
        this.amountPromoToClaim = 0d;
    }

    public Account(Double balance) {
        this.balance = balance;
        this.TransactionList = new ArrayList<>();
        this.amountPromoToClaim = 0d;
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

    public Double getBalancePromoToClaim() {
        return this.amountPromoToClaim;
    }

    public void subPromoAmountToClaim(Double amount) {
        this.amountPromoToClaim += amount;
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
