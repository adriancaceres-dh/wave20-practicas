package com.bootcamp.transactions;

public class BasicTransactions {

    public BalanceInquiry balanceInquiry;
    public Retire retire;

    public BasicTransactions(BalanceInquiry balanceInquiry, Retire retire) {
        this.balanceInquiry = balanceInquiry;
        this.retire = retire;
    }
}
