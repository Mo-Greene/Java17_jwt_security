package com.mo.securityprac.api.auth.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mo.securityprac.api.auth.model.User;
import com.mo.securityprac.api.auth.record.AuthRequest;
import com.mo.securityprac.api.auth.record.AuthResponse;
import com.mo.securityprac.api.auth.service.AuthService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AuthController {

	private final AuthService authService;

	@GetMapping("")
	public String hello() {
		return "hello world!";
	}

	@PostMapping("/auth/login")
	public ResponseEntity<AuthResponse> authenticate(@RequestBody AuthRequest authRequest) {
		User user = User.builder()
			.email(authRequest.email())
			.password(authRequest.password())
			.build();

		return ResponseEntity.ok(authService.authResponse(user));
	}
}
