package com.eduhub.instructorservice.repository;

import com.eduhub.instructorservice.entity.InstructorHasUserInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorHasUserInformationRepository extends JpaRepository<InstructorHasUserInformation, Long> {
}
