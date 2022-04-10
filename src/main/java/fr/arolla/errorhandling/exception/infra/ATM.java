package fr.arolla.errorhandling.exception.infra;

import fr.arolla.errorhandling.exception.domain.Amount;
import fr.arolla.errorhandling.exception.domain.BankAccount;
import fr.arolla.errorhandling.exception.domain.WithdrawalRefusedException;

import java.util.Scanner;

public class ATM {

    public static void main(String[] args) {

        var scanner = new Scanner(System.in);

        System.out.print("Initial amount: ");
        var bankAccount = createBankAccount(scanner.nextInt());

        try {
            System.out.print("Amount to withdraw: ");
            var balance = bankAccount.withdraw(new Amount(scanner.nextInt()));
            System.out.println("New balance: " + balance);
        } catch (WithdrawalRefusedException e) {
            System.err.println("Withdrawal refused");
        }
    }

    private static BankAccount createBankAccount(int amount) {
        return new BankAccount(new Amount(amount));
    }
}
