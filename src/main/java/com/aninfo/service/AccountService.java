package com.aninfo.service;

import com.aninfo.exceptions.DepositNegativeSumException;
import com.aninfo.exceptions.InsufficientFundsException;
import com.aninfo.model.Account;
import com.aninfo.model.Transaction;
import com.aninfo.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionService transactionService;

    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    public Collection<Account> getAccounts() {
        return accountRepository.findAll();
    }

    public Optional<Account> findById(Long cbu) {
        return accountRepository.findById(cbu);
    }

    public void save(Account account) {
        accountRepository.save(account);
    }

    public void deleteById(Long cbu) {
        accountRepository.deleteById(cbu);
    }

    @Transactional
    public Account withdraw(Long cbu, Double sum) {
        Account account = accountRepository.findAccountByCbu(cbu);

        if (account.getBalance() < sum) {
            throw new InsufficientFundsException("Insufficient funds");
        }

        Transaction transaction = transactionService.createWithdraw(cbu,sum);
        account.setBalance(account.getBalance() - sum);
        account.addTransaction(transaction);
        accountRepository.save(account);

        return account;
    }

    @Transactional
    public Account deposit(Long cbu, Double sum) {

        if (sum <= 0) {
            throw new DepositNegativeSumException("Cannot deposit negative sums");
        }

        Account account = accountRepository.findAccountByCbu(cbu);
        Double balancePromoInAccountToClaim = account.getBalancePromoToClaim();
        Double extraAmountPromo = sum * 0.1;

        if(sum >= 2000){
            if((balancePromoInAccountToClaim + extraAmountPromo) < 500){
                account.subPromoAmountToClaim(extraAmountPromo);
                sum += extraAmountPromo;
            }else{
                sum += 500 - balancePromoInAccountToClaim;
            }
        }


        Transaction transaction = transactionService.createDeposit(cbu,sum);

        account.setBalance(account.getBalance() + sum);
        account.addTransaction(transaction);
        accountRepository.save(account);

        return account;
    }

    public Optional<Transaction> getTransaction(Long _Id) {
        return transactionService.getTransactionById(_Id);
    }

    public List<Transaction> getTransactionsFromAccount(Long _Cbu) {
        return transactionService.getTransactionByCbu(_Cbu);

    }
    public void deleteTransaction(Long _Id) {
        transactionService.deleteTransaction(_Id);
    }

}
