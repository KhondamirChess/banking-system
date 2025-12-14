package org.dailycodework.bankingsystem.commands;
import org.dailycodework.bankingsystem.service.AccountService;
import org.springframework.stereotype.Component;
import java.util.Scanner;
@Component
public class AccountTransferCommand implements OperationCommand {
    private final AccountService accountService;
    public AccountTransferCommand(AccountService accountService) {
        this.accountService = accountService;
    }
    @Override
    public String getName() {
        return "ACCOUNT_TRANSFER";
    }
    @Override
    public void execute(Scanner scanner) {
        try {
            System.out.print("Enter source account ID: ");
            int fromAccountId = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter target account ID: ");
            int toAccountId = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter amount to transfer: ");
            int amount = Integer.parseInt(scanner.nextLine());
            accountService.transfer(fromAccountId, toAccountId, amount);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}