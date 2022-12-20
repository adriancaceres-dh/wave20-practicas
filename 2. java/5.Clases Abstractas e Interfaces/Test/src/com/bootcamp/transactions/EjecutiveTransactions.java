package com.bootcamp.transactions;

public class EjecutiveTransactions {

    public Deposits deposits;
    public Transfers transfers;

    public EjecutiveTransactions(Deposits deposits) {
        this.deposits = deposits;
    }

    public EjecutiveTransactions(Transfers transfers) {
        this.transfers = transfers;
    }

    public EjecutiveTransactions(Deposits deposits, Transfers transfers) {
        this.deposits = deposits;
        this.transfers = transfers;
    }
}
