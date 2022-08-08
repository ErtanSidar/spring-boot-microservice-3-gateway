package com.essoft.springbootmicroservice3gateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import com.essoft.springbootmicroservice3gateway.security.UserPrincipal;
import com.essoft.springbootmicroservice3gateway.service.ITransactionService;
import com.google.gson.JsonElement;

@RestController
@RequestMapping("gateway/transaction")
public class TransactionController
{
    @Autowired
    private ITransactionService transactionService;

    @PostMapping
    public ResponseEntity<?> saveTransaction(@RequestBody JsonElement transaction)
    {
        return ResponseEntity.ok(transactionService.saveTransaction(transaction));
    }

    @DeleteMapping("{transactionId}")
    public ResponseEntity<?> deleteTransaction(@PathVariable Long transactionId)
    {
        transactionService.deleteTransaction(transactionId);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAllTransactionsOfAuthorizedUser(@AuthenticationPrincipal UserPrincipal principal)
    {
        return ResponseEntity.ok(transactionService.getAllTransactionsOfUser(principal.getId()));
    }
}
