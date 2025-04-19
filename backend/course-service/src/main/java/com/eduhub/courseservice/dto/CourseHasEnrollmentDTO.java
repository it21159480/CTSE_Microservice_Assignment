package com.eduhub.courseservice.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@RequiredArgsConstructor
public class CourseHasEnrollmentDTO {
    private Long courseHasEnrollmentId;
    private Long learnerId;
    private Long financeId;
    private LocalDateTime createdDate;
}
