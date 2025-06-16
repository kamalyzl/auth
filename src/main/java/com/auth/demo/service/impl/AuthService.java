package com.auth.demo.service.impl;

import com.auth.demo.service.interfaces.IAuthService;
import com.auth.demo.token.interfaces.TokenProvider;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthService implements IAuthService {

    private final TokenProvider tokenProvider;

    @Override
    public String login(String username) {
        return tokenProvider.generateToken(username);
    }
}
