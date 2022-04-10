package fr.arolla.errorhandling.vavreither.infra;

import fr.arolla.errorhandling.vavreither.domain.Amount;
import fr.arolla.errorhandling.vavreither.domain.BankAccount;

import java.util.Scanner;

public class ATM {

    public static void main(String[] args) {

        var scanner = new Scanner(System.in);

        System.out.print("Initial amount: ");
        var bankAccount = createBankAccount(scanner.nextInt());

        System.out.print("Amount to withdraw: ");
        bankAccount.withdraw(new Amount(scanner.nextInt()))
                .peek(balance -> System.out.println("New balance: " + balance))
                .orElseRun(withdrawalRefused -> System.err.println("Withdrawal refused"));
    }

    private static BankAccount createBankAccount(int amount) {
        return new BankAccount(new Amount(amount));
    }
}
