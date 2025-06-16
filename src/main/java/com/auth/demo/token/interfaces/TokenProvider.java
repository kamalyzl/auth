package com.auth.demo.token.interfaces;

public interface TokenProvider {
    String generateToken(String username);
    String extractUsername(String token);
    boolean isTokenValid(String token, String username);
}
