package com.example.InternetShop.controller;

import com.example.InternetShop.service.UserService;
import com.example.InternetShop.configuration.JwtUtils;
import com.example.InternetShop.dto.LoginRequestDTO;
import com.example.InternetShop.dto.UserDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController
{
    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity authenticateUser(@RequestBody LoginRequestDTO loginRequest) {

        var authentication = authenticationManager
                                            .authenticate(
                                                new UsernamePasswordAuthenticationToken(
                                                    loginRequest.getEmail(),
                                                    loginRequest.getPassword()
                                                )
                                            );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        var jwtCookie = jwtUtils.generateTokenFromUsername(loginRequest.getEmail());

        return ResponseEntity.ok()
                   .header("Authentication", "Bearer-" + jwtCookie)
                   .build();
    }

    @PostMapping("create-user")
    public void add(@RequestBody UserDTO user) {
        userService.add(user);
    }
}
