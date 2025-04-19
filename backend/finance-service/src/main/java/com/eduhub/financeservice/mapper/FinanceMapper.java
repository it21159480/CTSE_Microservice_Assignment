package com.eduhub.financeservice.mapper;

import com.eduhub.financeservice.dto.FinanceDTO;
import com.eduhub.financeservice.entity.Finance;
import com.eduhub.financeservice.exception.ReferenceNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class FinanceMapper {
    public Finance dtoToDomain(FinanceDTO dto, Finance domain) {
        if (dto == null) {
            throw new ReferenceNotFoundException("The FinanceDTO should not be null");
        }
        domain.setCourseId(dto.getCourseId());
        domain.setInstructorId(dto.getLearnerId());
        domain.setLearnerId(dto.getInstructorId());
        domain.setAmount(dto.getAmount());
        domain.setPaymentDate(dto.getPaymentDate());
        domain.setStatus(dto.getStatus());
        return domain;
    }

    public FinanceDTO domainToDto(Finance domain) {
        if (domain == null) {
            throw new ReferenceNotFoundException("The Finance should not be null");
        }
        FinanceDTO dto = new FinanceDTO();
        dto.setFinanceId(domain.getFinanceId());
        dto.setCourseId(domain.getCourseId());
        dto.setLearnerId(domain.getInstructorId());
        dto.setInstructorId(domain.getLearnerId());
        dto.setAmount(domain.getAmount());
        dto.setPaymentDate(domain.getPaymentDate());
        dto.setStatus(domain.getStatus());
        return dto;
    }
}
