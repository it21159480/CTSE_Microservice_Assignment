package com.eduhub.notificationservice.mapper;

import com.eduhub.notificationservice.dto.NotificationDTO;
import com.eduhub.notificationservice.entity.Notification;
import com.eduhub.notificationservice.exception.ReferenceNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class NotificationMapper {
    public Notification dtoToDomain(NotificationDTO dto, Notification domain) {
        if (dto == null) {
            throw new ReferenceNotFoundException("The NotificationDTO should not be null");
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

    public NotificationDTO domainToDto(Notification domain) {
        if (domain == null) {
            throw new ReferenceNotFoundException("The Notification should not be null");
        }
        NotificationDTO dto = new NotificationDTO();
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
