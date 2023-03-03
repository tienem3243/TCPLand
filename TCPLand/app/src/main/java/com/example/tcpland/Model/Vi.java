package com.example.tcpland.Model;

public class Vi {


    public Vi(String accountAddress, Double balance) {
        this.accountAddress = accountAddress;
        balance = balance;
    }
    public Vi() {
    }
    private Double balance=0d;
    String accountAddress;


    public Double getBalance() {
        return balance;
    }

    public String getAccountAddress() {
        return accountAddress;
    }

    public Vi setAccountAddress(String accountAddress) {
        this.accountAddress = accountAddress;
        return this;
    }

    public Vi setBalance(Double balance) {
        this.balance = balance;
        return this;
    }

    public Vi createVi() {
        return new Vi(accountAddress, balance);
    }
}
