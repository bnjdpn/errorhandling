package fr.arolla.errorhandling.exception.domain;

public record Amount(int value) {

    public Amount subtract(Amount amount) {
        return new Amount(value - amount.value());
    }

}
