package fr.arolla.errorhandling.vavrmatch.infra;

import fr.arolla.errorhandling.vavrmatch.domain.Amount;
import fr.arolla.errorhandling.vavrmatch.domain.BankAccount;
import fr.arolla.errorhandling.vavrmatch.domain.WithdrawalRefused;
import fr.arolla.errorhandling.vavrmatch.domain.WithdrawalSuccess;

import java.util.Scanner;

import static io.vavr.API.$;
import static io.vavr.API.Case;
import static io.vavr.API.Match;
import static io.vavr.API.run;
import static io.vavr.Predicates.instanceOf;

public class ATM {

    public static void main(String[] args) {

        var scanner = new Scanner(System.in);

        System.out.print("Initial amount: ");
        var bankAccount = createBankAccount(scanner.nextInt());

        System.out.print("Amount to withdraw: ");
        var result = bankAccount.withdraw(new Amount(scanner.nextInt()));

        Match(result).of(
                Case($(instanceOf(WithdrawalSuccess.class)), success -> run(() -> System.out.println("New balance: " + success.newBalance()))),
                Case($(instanceOf(WithdrawalRefused.class)), ignored -> run(() -> System.err.println("Withdrawal refused")))
        );
    }

    private static BankAccount createBankAccount(int amount) {
        return new BankAccount(new Amount(amount));
    }
}
