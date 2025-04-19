//Repository Class
package com.eduhub.learnerservice.repository;

import com.eduhub.learnerservice.entity.Learner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LearnerRepository extends JpaRepository<Learner, Long> {
}
