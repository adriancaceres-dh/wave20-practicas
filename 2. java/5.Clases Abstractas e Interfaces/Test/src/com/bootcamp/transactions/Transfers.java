package com.bootcamp.transactions;

public class Transfers implements ITransactionsOptions {
    int value;
    String name;

    public Transfers(int value) {
        this.value = value;
    }

    public Transfers(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void transactionOk() {
        System.out.println("Transfers ok de " + value + " para " + name);
    }

    public void transactionNoOk() {
        System.out.println("Transfers no ok");
    }
}
