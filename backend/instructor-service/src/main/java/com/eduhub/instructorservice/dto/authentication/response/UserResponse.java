package com.eduhub.instructorservice.dto.authentication.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

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
