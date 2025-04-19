package com.eduhub.learnerservice.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@DynamicUpdate
@Table(name = "learner_has_user_information")
public class LearnerHasUserInformation {
    @Id
    @Column(name = "idlearner_has_user_information", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn (name = "learner_id", nullable = false)
//    private Learner learner;

    @Column (name = "learner_id", nullable = false)
    private Long learnerId;

    @Column (name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

}
