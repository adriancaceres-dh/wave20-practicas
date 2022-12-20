package com.bootcamp.transactions;

public class Deposits implements ITransactionsOptions {
    int valor;

    public Deposits(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public void transactionOk() {
        System.out.println("Desposits ok de " + valor);
    }

    public void transactionNoOk() {
        System.out.println("Desposits no ok");
    }
}
