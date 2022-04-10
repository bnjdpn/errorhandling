package fr.arolla.errorhandling.resultswitch.domain;

public record WithdrawalSuccess(Amount newBalance) implements WithdrawalResult {
}
