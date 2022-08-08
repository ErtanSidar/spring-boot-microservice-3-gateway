package com.essoft.springbootmicroservice3gateway.security.jwt;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;

import com.essoft.springbootmicroservice3gateway.security.UserPrincipal;

public interface IJwtProvider
{
    String generateToken(UserPrincipal authentication);

    Authentication getAuthentication(HttpServletRequest request);

    boolean isTokenValid(HttpServletRequest request);
}
