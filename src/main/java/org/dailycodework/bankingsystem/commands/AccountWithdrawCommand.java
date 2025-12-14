package org.dailycodework.bankingsystem.commands;
import org.dailycodework.bankingsystem.service.AccountService;
import org.springframework.stereotype.Component;
import java.util.Scanner;
@Component
public class AccountWithdrawCommand implements OperationCommand{
    private final AccountService accountService;
    public AccountWithdrawCommand(AccountService accountService) {
        this.accountService = accountService;
    }
    @Override
    public String getName(){
        return "ACCOUNT_WITHDRAW";
    }
    public void execute(Scanner scanner) {
        try {
            System.out.print("Enter account ID: ");
            int accountId = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter amount: ");
            int amount = Integer.parseInt(scanner.nextLine());
            accountService.withdraw(accountId, amount);
            System.out.println("Money successfully withdrawn");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
