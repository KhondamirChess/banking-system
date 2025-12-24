package org.dailycodework.bankingsystem.commands;
import org.dailycodework.bankingsystem.service.AccountService;
import org.springframework.stereotype.Component;
import java.util.Scanner;
@Component
public class AccountCloseCommand implements OperationCommand {
    private final AccountService accountService;
    public AccountCloseCommand(AccountService accountService) {
        this.accountService = accountService;
    }
    @Override
    public String getName(){
        return "ACCOUNT_CLOSE";
    }
    public void execute(Scanner scanner) {
        System.out.print("Enter account ID: ");

        int accountId;
        try {
            accountId = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid account ID");
            return;
        }
        try {
            accountService.closeAccount(accountId);
            System.out.println("Account closed successfully");
        } catch (IllegalStateException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
