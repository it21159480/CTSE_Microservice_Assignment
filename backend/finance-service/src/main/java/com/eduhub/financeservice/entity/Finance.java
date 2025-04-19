package com.eduhub.financeservice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "finance")
public class Finance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "finance_id")
    private Long financeId;
    @Column(name = "course_id")
    private Long courseId;
    @Column(name = "learner_Id")
    private Long learnerId;
    @Column(name = "instructor_id")
    private Long instructorId;
    @Column(name = "amount")
    private Double amount;
    @Column(name = "payment_date")
    private LocalDate paymentDate;
    @Column(name = "status")
    private String status;
}
