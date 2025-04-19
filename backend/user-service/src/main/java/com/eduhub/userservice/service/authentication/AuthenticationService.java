package com.eduhub.userservice.service.authentication;

import com.eduhub.userservice.dto.authentication.request.LoginRequest;
import com.eduhub.userservice.dto.authentication.request.SignupRequest;
import com.eduhub.userservice.dto.authentication.response.JwtResponse;
import com.eduhub.userservice.dto.authentication.response.MessageResponse;
import org.springframework.http.ResponseEntity;

public interface AuthenticationService {
    ResponseEntity<JwtResponse> authenticateUserDetails(LoginRequest loginRequest);

    ResponseEntity<MessageResponse> registerUserDetails(SignupRequest signUpRequest);

    ResponseEntity<MessageResponse> getUserById(Long userId);
}
