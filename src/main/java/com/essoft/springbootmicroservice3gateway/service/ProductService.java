package com.essoft.springbootmicroservice3gateway.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.google.gson.JsonElement;
import com.essoft.springbootmicroservice3gateway.request.IProductServiceRequest;
import com.essoft.springbootmicroservice3gateway.util.RetrofitUtils;

import java.util.List;


@Slf4j
@Service
public class ProductService implements IProductService
{
    @Autowired
    private IProductServiceRequest productServiceRequest;

    @Override
    public JsonElement saveProduct(JsonElement requestBody)
    {
        return RetrofitUtils.executeInBlock(productServiceRequest.saveProduct(requestBody));
    }

    @Override
    public void deleteProduct(Long productId)
    {
        RetrofitUtils.executeInBlock(productServiceRequest.deleteProduct(productId));
    }

    @Override
    public List<JsonElement> getAllProducts()
    {
        return RetrofitUtils.executeInBlock(productServiceRequest.getAllProducts());
    }
}
