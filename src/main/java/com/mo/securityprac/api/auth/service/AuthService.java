package com.mo.securityprac.api.auth.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import com.mo.securityprac.api.auth.model.User;
import com.mo.securityprac.api.auth.record.AuthResponse;
import com.mo.securityprac.jwt.JwtService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

	private final AuthenticationManager authenticationManager;
	private final JwtService jwtService;

	public AuthResponse authResponse(User user) {
		authenticationManager.authenticate(
			new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword())
		);
		return new AuthResponse(jwtService.generateToken(user));
	}
}
