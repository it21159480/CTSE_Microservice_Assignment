package com.eduhub.learnerservice.dto.authentication.response;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@RequiredArgsConstructor
public class UserResponse {
    private Long id;
    private String userId;
    private String username;
    private String email;
    private String password;
    private Set<Role> roles = new HashSet<>();
}
