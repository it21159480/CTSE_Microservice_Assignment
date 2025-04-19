package com.eduhub.financeservice.service;

import com.eduhub.financeservice.common.CommonResponse;
import com.eduhub.financeservice.dto.FinanceDTO;

public interface FinanceService {
    /**
     * Get all finances
     *
     * @return success or fail response of finances fetching
     */
    CommonResponse getAllFinanceDetails();

    /**
     * Get finance by finance id
     *
     * @param financeId - required data for get finance by id
     * @return success or fail response of get finance by id
     */
    CommonResponse getFinancesDetailsById(Long financeId);

    /**
     * Create finance
     *
     * @param financeDTO - required data for finance save
     * @return success or fail response of finance save
     */
    CommonResponse saveFinance(FinanceDTO financeDTO);

    /**
     * Update finance
     *
     * @param financeDTO - required data for finance update
     * @return success or fail response of finance update
     */
    CommonResponse updateFinance(FinanceDTO financeDTO);

    /**
     * Delete finance by id
     *
     * @param financeId - required data for delete finance by id
     * @return success or fail response of delete finance by id
     */
    CommonResponse deleteFinanceDetailsById(Long financeId);

    /**
     * Delete finances
     *
     * @return success or fail response of delete finances
     */
    CommonResponse deleteFinances();
}
