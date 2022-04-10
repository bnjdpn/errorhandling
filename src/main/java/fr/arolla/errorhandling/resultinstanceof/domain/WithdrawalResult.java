package fr.arolla.errorhandling.resultinstanceof.domain;

public sealed interface WithdrawalResult {

    record WithdrawalRefused() implements WithdrawalResult {
    }

    record WithdrawalSuccess(Amount newBalance) implements WithdrawalResult {
    }
}
