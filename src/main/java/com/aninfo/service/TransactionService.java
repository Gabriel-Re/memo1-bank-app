package com.aninfo.service;

import com.aninfo.model.Account;
import com.aninfo.model.Transaction;
import com.aninfo.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public Transaction createTransactionDeposit(Transaction transaction, Account account) {
        //return accountRepository.save(account);
    }

    public Transaction createTransactionWithdraw(Transaction transaction, Account account) {
        //return accountRepository.save(account);
    }

    public List<Transaction> getAllTransactions(){
        //Pensar la logica de como retornar las transacciones
    }

    public Transaction getTransactionById(){
        //Pensar la logica de como retornar las transacciones
    }

    //Crear alguna funcion que ejecute la logica de las transacciones sea deposit o withdraw
}
