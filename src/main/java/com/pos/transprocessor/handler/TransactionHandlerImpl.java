package com.pos.transprocessor.handler;

import com.pos.transcore.bean.Transaction;
import com.pos.transcore.validation.ValidationManager;

import java.util.Locale;

public abstract class TransactionHandlerImpl<T>
        implements TransactionHandler<T> {

    /**
     * {@inheritDoc}
     *
     * @param t - Generic for transaction input
     */
    @Override
    public void process(T t) {
        Transaction trans = extract(t);
        validate(trans);
        // TODO other processing code after extracting and validating
    }

    /**
     * {@inheritDoc}
     *
     * @param trans - Transaction DTO
     */
    @Override
    public void validate(Transaction trans) {
        ValidationManager.validate(trans, Locale.getDefault());
        // TODO Locale should be intercepted
        // from request in case of using this library in web container
    }
}
