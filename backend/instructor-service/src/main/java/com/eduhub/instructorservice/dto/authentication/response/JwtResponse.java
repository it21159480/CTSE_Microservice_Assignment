package com.eduhub.instructorservice.dto.authentication.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JwtResponse {
	private String token;
	private String userId;
	private String type = "Bearer";
	private Long id;
	private String username;
	private String email;
	private List<String> roles;

	public JwtResponse(String accessToken, Long id, String userId, String username, String email, List<String> roles) {
		this.token = accessToken;
		this.id = id;
		this.userId = userId;
		this.username = username;
		this.email = email;
		this.roles = roles;
	}
}
