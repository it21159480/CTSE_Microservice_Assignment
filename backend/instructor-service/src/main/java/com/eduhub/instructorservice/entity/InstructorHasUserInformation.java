package com.eduhub.instructorservice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@DynamicUpdate
@Table(name = "instructor_has_user_information")
public class InstructorHasUserInformation {
    @Id
    @Column(name = "idinstructor_has_user_information", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn (name = "instructor_id", nullable = false)
    private Instructor instructor;

    @Column (name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

}
