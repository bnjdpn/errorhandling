package fr.arolla.errorhandling.resultinstanceof.domain;

import fr.arolla.errorhandling.resultinstanceof.domain.WithdrawalResult.WithdrawalRefused;
import fr.arolla.errorhandling.resultinstanceof.domain.WithdrawalResult.WithdrawalSuccess;

public class BankAccount {

    private Amount balance;

    public BankAccount(Amount balance) {
        this.balance = balance;
    }

    public WithdrawalResult withdraw(Amount amount) {

        if (hasInsufficientBalance(amount)) {
            return new WithdrawalRefused();
        }

        balance = balance.subtract(amount);

        return new WithdrawalSuccess(balance);
    }

    private boolean hasInsufficientBalance(Amount amount) {
        return amount.value() > balance.value();
    }
}
