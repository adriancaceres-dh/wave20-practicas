package com.bootcamp.transactions;

public class BalanceInquiry implements ITransactionsOptions {
    int value = 1000000;

    public BalanceInquiry(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void transactionOk() {
        System.out.println("Your balance is " + value);
    }

    public void transactionNoOk() {
        System.out.println("Balance no ok");
    }
}
