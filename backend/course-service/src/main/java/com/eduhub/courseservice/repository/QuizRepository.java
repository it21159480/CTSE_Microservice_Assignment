package com.eduhub.courseservice.repository;

import com.eduhub.courseservice.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
}
