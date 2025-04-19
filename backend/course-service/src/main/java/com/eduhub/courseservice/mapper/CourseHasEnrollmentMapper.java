package com.eduhub.courseservice.mapper;

import com.eduhub.courseservice.dto.CourseHasEnrollmentDTO;
import com.eduhub.courseservice.entity.CourseHasEnrollment;
import com.eduhub.courseservice.exception.ReferenceNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class CourseHasEnrollmentMapper {
    public CourseHasEnrollment dtoToDomain(CourseHasEnrollmentDTO dto, CourseHasEnrollment domain) {
        if (dto == null) {
            throw new ReferenceNotFoundException("The CourseHasEnrollmentDTO should not be null");
        }
        domain.setFinanceId(dto.getFinanceId());
        domain.setLearnerId(dto.getLearnerId());
        domain.setCreatedDate(dto.getCreatedDate());
        return domain;
    }

    public CourseHasEnrollmentDTO domainToDto(CourseHasEnrollment domain) {
        if (domain == null) {
            throw new ReferenceNotFoundException("The CourseHasEnrollment should not be null");
        }
        CourseHasEnrollmentDTO dto = new CourseHasEnrollmentDTO();
        dto.setCourseHasEnrollmentId(domain.getCourseHasEnrollmentId());
        dto.setFinanceId(dto.getFinanceId());
        dto.setLearnerId(dto.getLearnerId());
        dto.setCreatedDate(dto.getCreatedDate());
        return dto;
    }
}
