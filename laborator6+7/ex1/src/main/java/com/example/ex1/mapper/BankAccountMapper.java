package com.example.ex1.mapper;

import com.example.ex1.dto.BankAccountRequest;
import com.example.ex1.model.BankAccount;
import org.springframework.stereotype.Component;

@Component
public class BankAccountMapper {
    public BankAccount convertRequestToBankAccount(BankAccountRequest bankAccountRequest) {
        return new BankAccount(bankAccountRequest.getAccountNumber(),
                bankAccountRequest.getAccountName(),
                bankAccountRequest.getAccountType(),
                bankAccountRequest.getBalance(),
                bankAccountRequest.getCurrency());
    }
}
