package com.example.ex1.controller;

import com.example.ex1.dto.BankAccountRequest;
import com.example.ex1.exceptionhandling.BankAccountNotFoundException;
import com.example.ex1.mapper.BankAccountMapper;
import com.example.ex1.model.BankAccount;
import com.example.ex1.service.BankAccountService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/bankAccount")
//@Validated
public class BankAccountController {

    private BankAccountService bankAccountService;
    private BankAccountMapper bankAccountMapper;

    public BankAccountController(BankAccountService bankAccountService, BankAccountMapper bankAccountMapper) {
        this.bankAccountService = bankAccountService;
        this.bankAccountMapper = bankAccountMapper;
    }

    @GetMapping("/listAccounts")
    public ResponseEntity<List<BankAccount>> bankAccounts() {
        return ResponseEntity.ok()
                .body(bankAccountService.findAllBankAccounts());
    }

    @PostMapping("/new")
    public ResponseEntity<BankAccount> newBankAccount(@RequestBody @Valid BankAccountRequest bankAccountRequest){
        return ResponseEntity
                .created(URI.create("bankAccount/byName" + bankAccountRequest.getAccountName()))
                .body(bankAccountService.addNewBankAccount(bankAccountMapper.convertRequestToBankAccount(bankAccountRequest)));
    }

    @GetMapping("/byName/{bankAccountName}")
    public ResponseEntity<?> findBankAccountByName(@PathVariable String bankAccountName){
            return ResponseEntity.ok()
                    .body(bankAccountService.findBankAccountByName(bankAccountName));
    }
}
