package com.eduhub.instructorservice.repository;

import com.eduhub.instructorservice.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepository extends JpaRepository<Instructor, Long> {
}
