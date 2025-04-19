package com.eduhub.instructorservice.dto;

import com.eduhub.instructorservice.entity.Instructor;
import com.eduhub.instructorservice.dto.authentication.response.UserResponse;
import com.eduhub.instructorservice.entity.InstructorHasUserInformation;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class InstructorResponseDTO {
    private Instructor instructor;
    private UserResponse userResponse;
    private InstructorHasUserInformation instructorHasUserInformation;
}
