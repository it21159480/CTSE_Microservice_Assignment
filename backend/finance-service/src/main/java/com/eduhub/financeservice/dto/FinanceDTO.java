package com.eduhub.financeservice.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@RequiredArgsConstructor
public class FinanceDTO {
    private Long financeId;
    private Long courseId;
    private Long learnerId;
    private Long instructorId;
    private Double amount;
    private LocalDate paymentDate;
    private String status;
}
