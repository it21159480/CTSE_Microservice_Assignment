package com.eduhub.learnerservice.mapper;

import com.eduhub.learnerservice.dto.LearnerDTO;
import com.eduhub.learnerservice.entity.Learner;
import com.eduhub.learnerservice.exception.ReferenceNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class LearnerMapper {
    public Learner dtoToDomain(LearnerDTO dto, Learner domain) {
        if (dto == null) {
            throw new ReferenceNotFoundException("The LearnerDTO should not be null");
        }
        domain.setFirstName(dto.getFirstName());
        domain.setLastName(dto.getLastName());
        domain.setPhone(dto.getPhone());
        domain.setAddress(dto.getAddress());
        domain.setCity(dto.getCity());
        domain.setCountry(dto.getCountry());
        return domain;
    }

    public LearnerDTO domainToDto(Learner domain) {
        if (domain == null) {
            throw new ReferenceNotFoundException("The Learner should not be null");
        }
        LearnerDTO dto = new LearnerDTO();
        dto.setLearnerId(domain.getLearnerId());
        dto.setFirstName(domain.getFirstName());
        dto.setLastName(domain.getLastName());
        dto.setPhone(domain.getPhone());
        dto.setAddress(domain.getAddress());
        dto.setCity(domain.getCity());
        dto.setCountry(domain.getCountry());
        return dto;
    }
}
