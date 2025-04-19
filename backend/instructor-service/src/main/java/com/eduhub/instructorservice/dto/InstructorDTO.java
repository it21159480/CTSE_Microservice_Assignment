package com.eduhub.instructorservice.dto;

import com.eduhub.instructorservice.dto.authentication.request.SignupRequest;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class InstructorDTO {
    private Long instructorId;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;
    private String city;
    private String country;
    private String degreeName;
    private String fieldOfStudy;
    private String yearsOfExperience;
    private SignupRequest signupRequest;
}
