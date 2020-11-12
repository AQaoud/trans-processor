package com.pos.transprocessor.handler;


import com.pos.transcore.bean.Transaction;


/**
 * Interface for handling transactions.
 *
 * @param <T>
 */
public interface TransactionHandler<T> {


    /**
     * Processing an input as a transaction.
     *
     * @param t - Generic for transaction input
     */
    void process(T t);

    /**
     * Extracting a <code>Transaction</code> DTO from generic input.
     *
     * @param t - Generic for transaction input
     * @return <code>Transaction</code> DTO object
     */
    Transaction extract(T t);

    /**
     * Validating transaction DTO.
     *
     * @param trans - Transaction DTO
     */
    void validate(Transaction trans);


}
