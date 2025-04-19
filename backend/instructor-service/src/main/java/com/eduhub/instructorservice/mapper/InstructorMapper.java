package com.eduhub.instructorservice.mapper;

import com.eduhub.instructorservice.dto.InstructorDTO;
import com.eduhub.instructorservice.entity.Instructor;
import com.eduhub.instructorservice.exception.ReferenceNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class InstructorMapper {
    public Instructor dtoToDomain(InstructorDTO dto, Instructor domain) {
        if (dto == null) {
            throw new ReferenceNotFoundException("The InstructorDTO should not be null");
        }
        domain.setFirstName(dto.getFirstName());
        domain.setLastName(dto.getLastName());
        domain.setPhone(dto.getPhone());
        domain.setAddress(dto.getAddress());
        domain.setCity(dto.getCity());
        domain.setCountry(dto.getCountry());
        domain.setDegreeName(dto.getDegreeName());
        domain.setFieldOfStudy(dto.getFieldOfStudy());
        domain.setYearsOfExperience(dto.getYearsOfExperience());
        return domain;
    }

    public InstructorDTO domainToDto(Instructor domain) {
        if (domain == null) {
            throw new ReferenceNotFoundException("The Instructor should not be null");
        }
        InstructorDTO dto = new InstructorDTO();
        dto.setInstructorId(domain.getInstructorId());
        dto.setFirstName(domain.getFirstName());
        dto.setLastName(domain.getLastName());
        dto.setPhone(domain.getPhone());
        dto.setAddress(domain.getAddress());
        dto.setCity(domain.getCity());
        dto.setCountry(domain.getCountry());
        dto.setDegreeName(domain.getDegreeName());
        dto.setFieldOfStudy(domain.getFieldOfStudy());
        dto.setYearsOfExperience(domain.getYearsOfExperience());
        return dto;
    }
}
