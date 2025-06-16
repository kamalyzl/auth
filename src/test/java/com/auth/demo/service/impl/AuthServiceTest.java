package com.auth.demo.service.impl;

import com.auth.demo.token.interfaces.TokenProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;


class AuthServiceTest {

    private TokenProvider tokenProvider;
    private AuthService authService;


    @BeforeEach
    void setUp() {
        tokenProvider = Mockito.mock(TokenProvider.class);
        authService = new AuthService(tokenProvider);
    }

    @Test
    void successfulLogin() {
        String username = "usuario1";
        String expectedToken = "mockedToken123";

        when(tokenProvider.generateToken(username)).thenReturn(expectedToken);

        String generatedToken = authService.login(username);

        assertEquals(expectedToken, generatedToken);
        verify(tokenProvider, times(1)).generateToken(username);
    }
}