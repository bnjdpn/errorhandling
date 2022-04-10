package fr.arolla.errorhandling.resultinstanceof.infra;

import fr.arolla.errorhandling.resultinstanceof.domain.Amount;
import fr.arolla.errorhandling.resultinstanceof.domain.BankAccount;
import fr.arolla.errorhandling.resultinstanceof.domain.WithdrawalResult;

import java.util.Scanner;

public class ATM {

    public static void main(String[] args) {

        var scanner = new Scanner(System.in);

        System.out.print("Initial amount: ");
        var bankAccount = createBankAccount(scanner.nextInt());

        System.out.print("Amount to withdraw: ");
        var result = bankAccount.withdraw(new Amount(scanner.nextInt()));

        if (result instanceof WithdrawalResult.WithdrawalSuccess success) {
            System.out.println("New balance: " + success.newBalance());
        } else {
            System.err.println("Withdrawal refused");
        }
    }

    private static BankAccount createBankAccount(int amount) {
        return new BankAccount(new Amount(amount));
    }
}
