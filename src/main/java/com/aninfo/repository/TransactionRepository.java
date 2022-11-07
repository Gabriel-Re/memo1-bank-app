package com.aninfo.repository;

import com.aninfo.model.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface TransactionRepository extends CrudRepository<Transaction, Long> {

    Transaction findTransactionByTransactionId(Long transactionId);

    List<Transaction> findAllByCbu(Long clientCbu);

    @Override
    List<Transaction> findAll();

}