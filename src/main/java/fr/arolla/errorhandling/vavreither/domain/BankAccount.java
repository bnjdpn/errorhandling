package fr.arolla.errorhandling.vavreither.domain;

import io.vavr.control.Either;

public class BankAccount {

    private Amount balance;

    public BankAccount(Amount balance) {
        this.balance = balance;
    }

    public Either<WithdrawalRefused, Amount> withdraw(Amount amount) {

        if (hasInsufficientBalance(amount)) {
            return Either.left(new WithdrawalRefused());
        }

        balance = balance.subtract(amount);

        return Either.right(balance);
    }

    private boolean hasInsufficientBalance(Amount amount) {
        return amount.value() > balance.value();
    }
}
