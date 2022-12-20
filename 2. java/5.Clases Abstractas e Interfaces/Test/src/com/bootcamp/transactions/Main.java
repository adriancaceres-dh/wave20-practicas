package com.bootcamp.transactions;

public class Main {

    public static void main(String[] args) {
        Deposits dp = new Deposits(500);
        Transfers tf = new Transfers(1000, "Andres");
        Retire r = new Retire(200);
        BalanceInquiry bi = new BalanceInquiry(876);
        EjecutiveTransactions eT = new EjecutiveTransactions(dp, tf);
        BasicTransactions bT = new BasicTransactions(bi, r);
        eT.deposits.transactionNoOk();
        eT.deposits.transactionOk();
        eT.transfers.transactionNoOk();
        eT.transfers.transactionOk();
        bT.balanceInquiry.transactionNoOk();
        bT.balanceInquiry.transactionOk();
        bT.retire.transactionNoOk();
        bT.retire.transactionOk();
    }
}
