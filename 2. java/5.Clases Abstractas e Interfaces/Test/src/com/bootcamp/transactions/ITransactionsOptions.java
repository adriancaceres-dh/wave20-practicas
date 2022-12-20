package com.bootcamp.transactions;

public interface ITransactionsOptions {

    default void transactionOk() {
    }

    default void transactionNoOk() {

    }

}
