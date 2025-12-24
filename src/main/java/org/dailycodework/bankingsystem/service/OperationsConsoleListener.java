package org.dailycodework.bankingsystem.service;

import org.dailycodework.bankingsystem.commands.OperationCommand;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class OperationsConsoleListener {
    private final List<OperationCommand> commands;
    private final Scanner scanner = new Scanner(System.in);
    public OperationsConsoleListener(List<OperationCommand> commands) {
        this.commands = commands;
    }
    public void start() {
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

            if ("EXIT".equals(input)) {
                System.out.println("Exiting...");
                break;
            }
            boolean found = false;
            for (OperationCommand command : commands) {
                if (command.getName().equalsIgnoreCase(input)) {
                    command.execute(scanner);
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Invalid command");
            }
        }
    }
}