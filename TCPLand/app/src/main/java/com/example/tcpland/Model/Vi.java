package com.example.tcpland.Model;

public class Vi {
    private Double balance;

    public Vi(String accountAddress, Double balance) {
        this.accountAddress = accountAddress;
        Balance = balance;
    }
    public Vi() {
    }

    String accountAddress;
    Double Balance;

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
