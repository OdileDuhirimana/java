package com.rra.vehicletracking.service;

import com.rra.vehicletracking.dto.AuthenticationRequest;
import com.rra.vehicletracking.dto.AuthenticationResponse;
import com.rra.vehicletracking.dto.RegisterRequest;
import com.rra.vehicletracking.model.Role;
import com.rra.vehicletracking.model.User;
import com.rra.vehicletracking.repository.UserRepository;
import com.rra.vehicletracking.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        // Check if user already exists
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists");
        }
        if (userRepository.existsByPhone(request.getPhone())) {
            throw new RuntimeException("Phone number already exists");
        }
        if (userRepository.existsByNationalId(request.getNationalId())) {
            throw new RuntimeException("National ID already exists");
        }

        var user = User.builder()
                .names(request.getNames())
                .email(request.getEmail())
                .phone(request.getPhone())
                .nationalId(request.getNationalId())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.ROLE_STANDARD)
                .build();

        userRepository.save(user);

        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .message("User registered successfully")
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .message("User authenticated successfully")
                .build();
    }
} 