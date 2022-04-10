package fr.arolla.errorhandling.vavrexception.infra;

import fr.arolla.errorhandling.vavrexception.domain.Amount;
import fr.arolla.errorhandling.vavrexception.domain.BankAccount;
import fr.arolla.errorhandling.vavrexception.domain.WithdrawalRefusedException;
import io.vavr.control.Try;

import java.util.Scanner;

public class ATM {

    public static void main(String[] args) {

        var scanner = new Scanner(System.in);

        System.out.print("Initial amount: ");
        var bankAccount = createBankAccount(scanner.nextInt());

        System.out.print("Amount to withdraw: ");
        Try.of(() -> bankAccount.withdraw(new Amount(scanner.nextInt())))
                .onSuccess(balance -> System.out.println("New balance: " + balance))
                .onFailure(WithdrawalRefusedException.class, withdrawalRefusedException -> System.err.println("Withdrawal refused"));
    }

    private static BankAccount createBankAccount(int amount) {
        return new BankAccount(new Amount(amount));
    }
}
