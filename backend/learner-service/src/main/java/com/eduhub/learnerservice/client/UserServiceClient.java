package com.eduhub.learnerservice.client;

import com.eduhub.learnerservice.dto.authentication.request.LoginRequest;
import com.eduhub.learnerservice.dto.authentication.request.SignupRequest;
import com.eduhub.learnerservice.dto.authentication.response.JwtResponse;
import com.eduhub.learnerservice.dto.authentication.response.MessageResponse;
import feign.Headers;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "USER-SERVICE")
@Headers({"Content-Type: application/json"})
public interface UserServiceClient {
    @PostMapping("/api/auth/signin")
    public ResponseEntity<JwtResponse> authenticateUser(@Valid @RequestBody LoginRequest loginRequest);

    @PostMapping("/api/auth/signup")
    public ResponseEntity<MessageResponse> registerUser(@Valid @RequestBody SignupRequest signUpRequest);

    @GetMapping("/user/{userId}")
    public ResponseEntity<MessageResponse> getUserById(@Valid @PathVariable("userId") Long userId);
}
