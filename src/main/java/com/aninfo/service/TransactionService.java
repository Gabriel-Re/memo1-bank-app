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

    public Transaction createTransactionDeposit(Transaction _Transaction, Account _Account) {
        if(_Transaction.getTransactionAmount() <= 0){
            throw new DepositNegativeSumException("Can't deposite negative or cero amount");
        }
        //return accountRepository.save(account);
        return _Transaction;
    }

    public Transaction createTransactionWithdraw(Transaction _Transaction, Account _Account) {
        if(_Transaction.getTransactionAmount() <= 0){
            throw new WithdrawNegativeSumException("Can't withdraw negative or cero amount");
        }
        //return accountRepository.save(account);
        return _Transaction;
    }

    public List<Transaction> getTransactionByCbu(Long _Cbu){
        return transactionRepository.findTransactionsByCbu(_Cbu);
    }

    //public Optional<Transaction> getTransactionById(Long _Id){
        //return transactionRepository.findTransactionByTransactionId(_Id);
    //}

    //Crear alguna funcion que ejecute la logica de las transacciones sea deposit o withdraw
    private Transaction saveTransaction(Transaction _Transaction){
        return this.transactionRepository.save(_Transaction);
    }
}
