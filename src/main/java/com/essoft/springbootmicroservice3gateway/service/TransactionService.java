package com.essoft.springbootmicroservice3gateway.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.essoft.springbootmicroservice3gateway.request.ITransactionServiceRequest;
import com.essoft.springbootmicroservice3gateway.util.RetrofitUtils;
import com.google.gson.JsonElement;

@Service
public class TransactionService implements ITransactionService
{
    @Autowired
    private ITransactionServiceRequest transactionServiceRequest;

    @Override
    public JsonElement saveTransaction(JsonElement transaction)
    {
        return RetrofitUtils.executeInBlock(transactionServiceRequest.saveTransaction(transaction));
    }

    @Override
    public void deleteTransaction(Long transactionId)
    {
        RetrofitUtils.executeInBlock(transactionServiceRequest.deleteTransaction(transactionId));
    }

    @Override
    public List<JsonElement> getAllTransactionsOfUser(Long userId)
    {
        return RetrofitUtils.executeInBlock(transactionServiceRequest.getAllTransactionsOfAuthorizedUser(userId));
    }
}
