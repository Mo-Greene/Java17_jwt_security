package com.mo.securityprac;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.mo.securityprac.api.auth.model.User;
import com.mo.securityprac.api.auth.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class SecurityPracApplication implements CommandLineRunner {


	public static void main(String[] args) {
		SpringApplication.run(SecurityPracApplication.class, args);
	}

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	@Override
	public void run(String... args) throws Exception {

		List<User> userList = List.of(
			User.builder()
				.email("13blueboy13@naver.com")
				.password(passwordEncoder.encode("1234"))
				.build()
		);
		userRepository.saveAll(userList);
	}
}
