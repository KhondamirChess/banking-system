package org.dailycodework.bankingsystem.model;
public class Account {
    private int id;
    private int userId;
    private int balance;
    public Account(int id, int userId, int balance) {
        if (balance < 0){
            throw new IllegalArgumentException("Balance cannot be negative");
        }
        this.id = id;
        this.userId = userId;
        this.balance = balance;
    }
    public Account() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public int getBalance() {
        return balance;
    }
    public void setBalance(int balance) {
        if (balance < 0) {
            throw new IllegalArgumentException("Balance cannot be negative");
        }
        this.balance = balance;
    }
    public void deposit(int amount) {
        if (amount <= 0){
            throw new IllegalArgumentException("Amount cannot be negative");
        }
        this.balance += amount;
    }
    public void withdraw(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }
        if (balance < amount) {
            throw new IllegalStateException("Balance cannot be negative");
        }
        balance -= amount;
    }
    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", userId=" + userId +
                ", balance=" + balance +
                '}';
    }
}

