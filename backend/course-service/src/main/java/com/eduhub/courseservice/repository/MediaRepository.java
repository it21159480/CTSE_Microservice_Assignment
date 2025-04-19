package com.eduhub.courseservice.repository;

import com.eduhub.courseservice.entity.MediaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MediaRepository extends JpaRepository<MediaEntity, Long> {
}
