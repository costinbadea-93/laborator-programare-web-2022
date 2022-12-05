package com.example.ex1.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public class BankAccountRequest {
    @NotNull(message = "AccountNumber cannot be null")
    @NotBlank(message = "AccountNumber cannot be blank")
    private String accountNumber;
    @NotNull(message = "AccountName cannot be null")
    @NotBlank(message = "AccountName cannot be blank")
    private String accountName;
    @NotNull(message = "AccountType cannot be null")
    @NotBlank(message = "AccountType cannot be blank")
    private String accountType;
    @Min(value = 1,message = "BalanceValue should be greater than 1")
    private long balance;
    @Length(min = 1, max = 1, message = "Currency symbol should be one digit")
    private String currency;

    public BankAccountRequest(String accountNumber, String accountName, String accountType, long balance, String currency) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.accountType = accountType;
        this.balance = balance;
        this.currency = currency;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "BankAccountRequest{" +
                "accountNumber='" + accountNumber + '\'' +
                ", accountName='" + accountName + '\'' +
                ", accountType='" + accountType + '\'' +
                ", balance=" + balance +
                ", currency='" + currency + '\'' +
                '}';
    }
}
