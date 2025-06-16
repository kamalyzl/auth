package com.auth.demo.controller;
import com.auth.demo.model.AuthRequest;
import com.auth.demo.service.interfaces.IAuthService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

    private final IAuthService authService;

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody AuthRequest request) {
        String token = authService.login(request.getUsername());
        return Map.of("token", token);
    }
}
