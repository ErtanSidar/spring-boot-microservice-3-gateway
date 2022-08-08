package com.essoft.springbootmicroservice3gateway.service;

import com.essoft.springbootmicroservice3gateway.model.User;

public interface IAuthenticationService
{
    String signInAndReturnJWT(User signInRequest);
}
