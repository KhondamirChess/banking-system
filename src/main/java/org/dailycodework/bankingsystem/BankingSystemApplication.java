package org.dailycodework.bankingsystem;

import org.dailycodework.bankingsystem.service.AccountService;
import org.dailycodework.bankingsystem.service.OperationsConsoleListener;
import org.dailycodework.bankingsystem.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BankingSystemApplication {

    public static void main(String[] args) {
        UserService userService = new UserService();
        AccountService accountService = new AccountService();
        OperationsConsoleListener console = new OperationsConsoleListener(userService, accountService);
        console.start();
    }

}
