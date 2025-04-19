package com.eduhub.instructorservice.client;

import com.eduhub.instructorservice.dto.authentication.request.LoginRequest;
import com.eduhub.instructorservice.dto.authentication.request.SignupRequest;
import com.eduhub.instructorservice.dto.authentication.response.JwtResponse;
import com.eduhub.instructorservice.dto.authentication.response.MessageResponse;
import feign.Headers;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "USER-SERVICE")
@Headers({"Content-Type: application/json"})
public interface UserServiceClient {
    @PostMapping("/api/auth/signin")
    public ResponseEntity<JwtResponse> authenticateUser(@Valid @RequestBody LoginRequest loginRequest);

    @PostMapping("/api/auth/signup")
    public ResponseEntity<MessageResponse> registerUser(@Valid @RequestBody SignupRequest signUpRequest);
}
