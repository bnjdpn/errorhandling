package fr.arolla.errorhandling.resultswitch.domain;

public record Amount(int value) {

    public Amount subtract(Amount amount) {
        return new Amount(value - amount.value());
    }

}
