package com.eduhub.financeservice.repository;

import com.eduhub.financeservice.entity.Finance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinanceRepository extends JpaRepository<Finance, Long> {
}
