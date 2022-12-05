package com.example.ex1.service;

import com.example.ex1.model.BankAccount;
import com.example.ex1.repository.BankAccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankAccountService {
    private static final Logger logger = LoggerFactory.getLogger(BankAccountService.class);

    private BankAccountRepository bankAccountRepository;


    public BankAccountService(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    public List<BankAccount> findAllBankAccounts() {
        List<BankAccount> bankAccounts = bankAccountRepository.findAllBankAccounts();
        logger.info("Retrieving from repository: {}", bankAccounts);
        return bankAccounts;
    }

    public BankAccount addNewBankAccount(BankAccount bankAccount) {
        logger.info("A new bank account: {} has been added", bankAccount);
        return bankAccountRepository.addNewBankAccount(bankAccount);
    }

    public BankAccount findBankAccountByName(String bankAccountName){
        logger.info("Retrieving from repo bank account with name: {}", bankAccountName);
        return bankAccountRepository.findByName(bankAccountName);
    }
}
