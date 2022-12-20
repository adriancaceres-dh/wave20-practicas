package com.bootcamp.transactions;

public class Retire implements ITransactionsOptions {
    int value;

    public Retire(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void transactionOk() {

        System.out.println("You retired " + value);
    }

    public void transactionNoOk() {
        System.out.println("Retire no ok");
    }
}
