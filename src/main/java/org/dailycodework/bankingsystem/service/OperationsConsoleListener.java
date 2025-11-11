package org.dailycodework.bankingsystem.service;

import org.dailycodework.bankingsystem.model.User;

import java.util.Scanner;

public class OperationsConsoleListener {
    //Компонент, который слушает консольный ввод и исполняет соответствующие
    //команды, используя сервисы.

    private final UserService userService;
    private final AccountService accountService;

    public OperationsConsoleListener(UserService userService, AccountService accountService) {
        this.userService = userService;
        this.accountService = accountService;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);


        while (true) {
            System.out.println("""
                        Welcome to the banking system
                    1.USER_CREATE       - создать пользователя
                    2.SHOW_ALL_USERS    - показать всех пользователей
                    3.ACCOUNT_CREATE    - создать счет
                    4.ACCOUNT_DEPOSIT   - пополнить счет
                    5.ACCOUNT_WITHDRAW  - снять со счета
                    6.ACCOUNT_TRANSFER  - перевести между счетами
                    7.ACCOUNT_CLOSE     - закрыть счет
                    8.EXIT              - выход
                    """);
            System.out.print(">>> ");
            String input = scanner.nextLine();
            try {
                switch (input) {
                    case "1" -> {
                        System.out.println("Please enter login");
                        String login = scanner.nextLine();
                        userService.createUser(login);
                    }
                    case "2" -> {
                        for (User u : userService.getUsers()) {
                            System.out.println(u.getId() + ": " + u.getLogin());
                            u.getAccountList().forEach(a ->
                                    System.out.println("Account " + a.getId() + " — balance " + a.getBalance())
                            );
                        }
                    }
                    case "3" -> {
                        for (User u : userService.getUsers()) {
                            System.out.println(u.getId() + ": " + u.getLogin());
                        }
                        System.out.println("Please enter user ID: ");
                        int userId = Integer.parseInt(scanner.nextLine());
                        User user = userService.getUser(userId);
                        if (user == null) {
                            System.out.println("Account not found");
                            break;
                        }
                        accountService.createAccount(user);
                    }
                    case "4" -> {
                        System.out.println("Please enter Account ID: ");
                        int accountId = Integer.parseInt(scanner.nextLine());
                        System.out.println("Please enter Balance: ");
                        int amount = Integer.parseInt(scanner.nextLine());
                        accountService.deposit(accountId, amount);
                    }
                    case "5" -> {
                        System.out.println("Please enter Account ID: ");
                        int accountId = Integer.parseInt(scanner.nextLine());
                        System.out.println("Please enter Balance: ");
                        int amount = Integer.parseInt(scanner.nextLine());
                        accountService.withdraw(accountId, amount);
                    }
                    case "6" -> {
                        System.out.println("Enter source account ID: ");
                        int fromAccountId = Integer.parseInt(scanner.nextLine());
                        System.out.println("Enter target account ID: ");
                        int toAccountId = Integer.parseInt(scanner.nextLine());
                        System.out.println("Enter amount to transfer: ");
                        int amount = Integer.parseInt(scanner.nextLine());
                        accountService.transfer(fromAccountId, toAccountId, amount);
                    }
                    case "7" -> {
                        System.out.println("Please enter Account ID: ");
                        int accountId = Integer.parseInt(scanner.nextLine());
                        accountService.closeAccount(accountId);
                    }
                    case "8" -> {
                        System.out.println("EXIT");
                        System.exit(0);
                    }
                    default -> {
                        System.out.println("Invalid input");
                    }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
