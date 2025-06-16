package com.auth.demo.controller;

import com.auth.demo.model.AuthRequest;
import com.auth.demo.service.interfaces.IAuthService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AuthControllerTest {

    @Mock
    private IAuthService authService;

    @InjectMocks
    private AuthController authController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void login_deberiaRetornarToken() {
        AuthRequest request = new AuthRequest();
        request.setUsername("usuario1");

        String token = "fakeToken123";

        when(authService.login("usuario1")).thenReturn(token);

        Map<String, String> response = authController.login(request);

        assertNotNull(response);
        assertEquals(token, response.get("token"));
        verify(authService, times(1)).login("usuario1");
    }
}