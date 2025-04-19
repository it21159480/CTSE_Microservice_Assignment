//DTO Class
package com.eduhub.learnerservice.dto;

import com.eduhub.learnerservice.dto.authentication.request.SignupRequest;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
public class LearnerDTO {
    private Long learnerId;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;
    private String city;
    private String country;
    private SignupRequest signupRequest;
}
