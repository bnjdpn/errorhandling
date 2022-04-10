package fr.arolla.errorhandling.resultswitch.infra;

import fr.arolla.errorhandling.resultswitch.domain.Amount;
import fr.arolla.errorhandling.resultswitch.domain.BankAccount;
import fr.arolla.errorhandling.resultswitch.domain.WithdrawalRefused;
import fr.arolla.errorhandling.resultswitch.domain.WithdrawalSuccess;

import java.util.Scanner;

public class ATM {

    public static void main(String[] args) {

        var scanner = new Scanner(System.in);

        System.out.print("Initial amount: ");
        var bankAccount = createBankAccount(scanner.nextInt());

        System.out.print("Amount to withdraw: ");
        var result = bankAccount.withdraw(new Amount(scanner.nextInt()));

        switch (result) {
            case WithdrawalSuccess success -> System.out.println("New balance: " + success.newBalance());
            case WithdrawalRefused ignored -> System.err.println("Withdrawal refused");
        }
    }

    private static BankAccount createBankAccount(int amount) {
        return new BankAccount(new Amount(amount));
    }
}
