package com.eduhub.courseservice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "course_has_enrollment")
public class CourseHasEnrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_has_enrollment_id")
    private Long courseHasEnrollmentId;
    @Column(name = "learner_id")
    private Long learnerId;
    @Column(name = "finance_id")
    private Long financeId;
    @Column(name = "created_date")
    private LocalDateTime createdDate;
}
