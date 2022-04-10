package fr.arolla.errorhandling.exception.domain;

public class BankAccount {

    private Amount balance;

    public BankAccount(Amount balance) {
        this.balance = balance;
    }

    public Amount withdraw(Amount amount) throws WithdrawalRefusedException {

        if (hasInsufficientBalance(amount)) {
            throw new WithdrawalRefusedException();
        }

        balance = balance.subtract(amount);

        return balance;
    }

    private boolean hasInsufficientBalance(Amount amount) {
        return amount.value() > balance.value();
    }
}
