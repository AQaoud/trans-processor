package com.pos.transprocessor.handler;

import com.pos.transprocessor.input.grpc.Transaction;

/**
 * Handler for transactions passed through gRPC
 */
public class GrpcHandler extends TransactionHandlerImpl<Transaction> {

    @Override
    public com.pos.transcore.bean.Transaction extract(Transaction transaction) {
        com.pos.transcore.bean.Transaction transaction1 = map(transaction);
        return transaction1;
    }

    private com.pos.transcore.bean.Transaction map(Transaction transaction) {
        // TODO mapping between properties with the same name should be done
        return new com.pos.transcore.bean.Transaction();
    }
}
