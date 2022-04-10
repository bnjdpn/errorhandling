package fr.arolla.errorhandling.vavrmatch.domain;

public record WithdrawalSuccess(Amount newBalance) implements WithdrawalResult {
}
