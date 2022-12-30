package com.example.tcpland.Model;

public class Vi {
    public Vi(String accountAddress, Double balance) {
        this.accountAddress = accountAddress;
        Balance = balance;
    }

    public String getAccountAddress() {
        return accountAddress;
    }

    public void setAccountAddress(String accountAddress) {
        this.accountAddress = accountAddress;
    }

    public Double getBalance() {
        return Balance;
    }

    public void setBalance(Double balance) {
        Balance = balance;
    }

    String accountAddress;
    Double Balance;
}
