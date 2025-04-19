package com.eduhub.userservice.controller.authentication;

import com.eduhub.userservice.dto.authentication.request.LoginRequest;
import com.eduhub.userservice.dto.authentication.request.SignupRequest;
import com.eduhub.userservice.dto.authentication.response.JwtResponse;
import com.eduhub.userservice.dto.authentication.response.MessageResponse;
import com.eduhub.userservice.service.authentication.AuthenticationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthenticationController {
	private final AuthenticationService authenticationService;

	@PostMapping("/signin")
	public ResponseEntity<JwtResponse> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
		return authenticationService.authenticateUserDetails(loginRequest);
	}

	@PostMapping("/signup")
	public ResponseEntity<MessageResponse> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
		return authenticationService.registerUserDetails(signUpRequest);
	}

	@GetMapping("/user/{userId}")
	public ResponseEntity<MessageResponse> getUserById(@Valid @PathVariable("userId") Long userId) {
		return authenticationService.getUserById(userId);
	}
}
