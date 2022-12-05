package com.example.ex1.repository;

import com.example.ex1.model.BankAccount;
import com.example.ex1.exceptionhandling.BankAccountNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BankAccountRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

//    private List<BankAccount> bankAccountList = new ArrayList<>();

//    public BankAccountRepository(){
//        BankAccount b1 = new BankAccount("00000501A5",
//                "BankAcc501",
//                "Saving account",
//                20000,
//                "$"
//                );
//
//        BankAccount b2 = new BankAccount("00000502A5",
//                "BankAcc521",
//                "Checking account",
//                2000,
//                "$"
//        );
//        bankAccountList.add(b1);
//        bankAccountList.add(b2);
//    }

    public BankAccount addNewBankAccount(BankAccount bankAccount) {
//        bankAccountList.add(bankAccount);
//        return bankAccount;
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String sql = "INSERT INTO bank_account(accountNumber,accountName,accountType,balance,currency) VALUES(?,?,?,?,?)";
//        jdbcTemplate.update(sql, animal.getNume(), animal.getCuloare());
        jdbcTemplate.update(con -> {
            PreparedStatement preparedStatement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, bankAccount.getAccountNumber());
            preparedStatement.setString(2, bankAccount.getAccountName());
            preparedStatement.setString(3, bankAccount.getAccountType());
            preparedStatement.setLong(4, bankAccount.getBalance());
            preparedStatement.setString(5, bankAccount.getCurrency());
            return preparedStatement;
        }, keyHolder);
        System.out.println("Noul id generat este: " + keyHolder.getKey().intValue());
        bankAccount.setId(keyHolder.getKey().intValue());
        return bankAccount;
    }

    public BankAccount findByName(String bankAccountName) {
//        return bankAccountList.stream()
//                .filter(bankAccount -> bankAccount.getAccountName().equalsIgnoreCase(bankAccountName))
//                .findFirst()
//                .orElseThrow(() -> new BankAccountNotFoundException("Bank account not found for the given name!"));
        String sql = "select * FROM bank_account WHERE accountName = ?";

        BankAccount bankAccount = jdbcTemplate.queryForObject(sql, (rs, rowNum) ->
                        new BankAccount(
                                rs.getInt("id"),
                                rs.getString("accountNumber"),
                                rs.getString("accountName"),
                                rs.getString("accountType"),
                                rs.getLong("balance"),
                                rs.getString("currency")),
                bankAccountName);

        return bankAccount;

    }

    public List<BankAccount> findAllBankAccounts() {
//        return bankAccountList;

        String sql = "SELECT * FROM bank_account";
        List<BankAccount> bankAccounts = jdbcTemplate.query(sql, (rs, rowNum) ->
                new BankAccount(
                        rs.getInt("id"),
                        rs.getString("accountNumber"),
                        rs.getString("accountName"),
                        rs.getString("accountType"),
                        rs.getLong("balance"),
                        rs.getString("currency")));

        return bankAccounts;
    }
}
