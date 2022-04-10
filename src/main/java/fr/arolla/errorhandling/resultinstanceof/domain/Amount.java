package fr.arolla.errorhandling.resultinstanceof.domain;

public record Amount(int value) {

    public Amount subtract(Amount amount) {
        return new Amount(value - amount.value());
    }

}
