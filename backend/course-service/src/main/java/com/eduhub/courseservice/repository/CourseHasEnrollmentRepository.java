package com.eduhub.courseservice.repository;

import com.eduhub.courseservice.entity.CourseHasEnrollment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseHasEnrollmentRepository extends JpaRepository<CourseHasEnrollment, Long> {
}
