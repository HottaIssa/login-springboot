package com.saihoz.login.Service;

import org.springframework.stereotype.Service;

import com.saihoz.login.Jwt.JwtService;
import com.saihoz.login.Model.User.Role;
import com.saihoz.login.Model.User.User;
import com.saihoz.login.Repository.UserRepository;
import com.saihoz.login.Request.AuthResponse;
import com.saihoz.login.Request.LoginRequest;
import com.saihoz.login.Request.RegisterRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;

    public AuthResponse login(LoginRequest request) {
        return null;
    }

    public AuthResponse register(RegisterRequest request) {
        User user = User.builder()
                            .username(request.getUsername())
                            .password(request.getPassword())
                            .firstname(request.getFirstname())
                            .lastname(request.getLastname())
                            .email(request.getEmail())
                            .country(request.getCountry())
                            .role(Role.USER)
                            .build();
        
        userRepository.save(user);
        
        return AuthResponse.builder()
                .token(jwtService.getToken(user))
                .build();
    }

}
