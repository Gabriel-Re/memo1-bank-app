package com.aninfo.service;

import com.aninfo.exceptions.DepositNegativeSumException;
import com.aninfo.exceptions.WithdrawNegativeSumException;
import com.aninfo.model.Account;
import com.aninfo.model.Transaction;
import com.aninfo.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public Transaction createTransactionDeposit(Transaction transaction, Account account) {
        if(transaction.getTransactionAmount() <= 0){
            throw new DepositNegativeSumException("Can't deposite negative or cero amount");
        }
        //return accountRepository.save(account);
    }

    public Transaction createTransactionWithdraw(Transaction transaction, Account account) {
        if(transaction.getTransactionAmount() <= 0){
            throw new WithdrawNegativeSumException("Can't withdraw negative or cero amount");
        }
        //return accountRepository.save(account);
    }

    public List<Transaction> getAllTransactions(){
        return transactionRepository.findAll();
    }

    public Optional<Transaction> getTransactionById(long _Id){
        return transactionRepository.findById(_Id);
    }

    //Crear alguna funcion que ejecute la logica de las transacciones sea deposit o withdraw
}
