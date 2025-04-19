package com.eduhub.learnerservice.repository;

import com.eduhub.learnerservice.entity.Learner;
import com.eduhub.learnerservice.entity.LearnerHasUserInformation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LearnerHasUserInformationRepository extends JpaRepository<LearnerHasUserInformation, Long> {
    Optional<LearnerHasUserInformation> findByLearnerId(Long learner);
}
