package com.auth.demo.token.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JwtTokenProviderTest {

    private JwtTokenProvider jwtTokenProvider;

    @BeforeEach
    void setUp() {
        jwtTokenProvider = new JwtTokenProvider();
    }

    @Test
    void successfulGenerateToken() {
        String username = "testuser";
        String token = jwtTokenProvider.generateToken(username);
        assertNotNull(token);
        assertFalse(token.isEmpty());
    }

    @Test
    void successfulExtractUsername() {
        String username = "extractUser";
        String token = jwtTokenProvider.generateToken(username);
        String extraido = jwtTokenProvider.extractUsername(token);
        assertEquals(username, extraido);
    }

    @Test
    void successfulIsTokenValid() {
        String username = "validUser";
        String token = jwtTokenProvider.generateToken(username);
        assertTrue(jwtTokenProvider.isTokenValid(token, username));
    }

    @Test
    void isTokenValid_conUsernameIncorrecto_deberiaSerInvalido() {
        String token = jwtTokenProvider.generateToken("user123");
        assertFalse(jwtTokenProvider.isTokenValid(token, "otroUser"));
    }
}