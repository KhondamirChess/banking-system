package org.dailycodework.bankingsystem.service;

import org.dailycodework.bankingsystem.model.Account;
import org.dailycodework.bankingsystem.model.User;

import java.util.HashMap;
import java.util.Map;

public class AccountService {
    //Сервис для управления счетами. Содержит методы для создания счета, пополнения и
    //снятия средств, перевода средств между счетами и закрытия счета.

    private final Map<Integer, Account> accounts = new HashMap<>();

    private int accountCounter = 1;

    public Account createAccount(User user) {
        System.out.println("Enter the user id for which to create an account: ");
        Account account = new Account();
        account.setId(accountCounter++);
        account.setUserId(user.getId());
        account.setBalance(0);
        user.getAccountList().add(account);
        accounts.put(account.getId(), account);
        System.out.println("New account created with ID: " + account.getId() + " Account created for user: " + user.getLogin());
        return account;
    }

    public void deposit(int accountId, int amount) {
        Account account = accounts.get(accountId);
        if (account == null) {
            System.out.println("Account not found");
            return;
        }
        if (amount < 0) {
            System.out.println("Invalid amount");
            return;
        }
        account.deposit(amount);
        System.out.println("Amount " + amount + " deposited to account ID: " + account.getId());
    }

    public void withdraw(int accountId, int amount) {
        Account account = accounts.get(accountId);
        if (account == null) {
            System.out.println("Account not found");
            return;
        }
        if (amount < 0) {
            System.out.println("Invalid amount");
            return;
        }
        boolean success = account.withdraw(amount);
        if (success) {
            System.out.println("Amount " + amount + " withdrawn to account ID: " + account.getId());
        }else {
            System.out.println("No such money to withdraw");
        }
    }

    public void transfer(int fromAccountId, int toAccountId, int amount) {
        Account fromAccount = accounts.get(fromAccountId);
        Account toAccount = accounts.get(toAccountId);

        if (fromAccount == null || toAccount == null) {
            System.out.println("Account not found");
            return;
        }
        if (amount < 0) {
            System.out.println("Invalid amount");
            return;
        }

        if (!fromAccount.withdraw(amount)) {
            System.out.println("Insufficient amount");
            return;
        }

        toAccount.deposit(amount);
        System.out.println("From account with ID " + fromAccountId + " deposited " + amount + " to account with ID " + toAccountId);
    }

    public void closeAccount(int accountId) {
        Account account = accounts.get(accountId);
        if (account == null) {
            System.out.println("Account not found");
            return;
        }

        if (account.getBalance() == 0) {
            System.out.println("Insufficient balance");
            return;
        }
        accounts.remove(accountId);
        System.out.println("Account with ID: " + accountId + " has been closed");
    }

    public Account getAccountById(int id) {
        return accounts.get(id);
    }

    public boolean exists(int id) {
        return accounts.containsKey(id);
    }

}
