package com.eduhub.financeservice.controller;

import com.eduhub.financeservice.common.CommonResponse;
import com.eduhub.financeservice.dto.FinanceDTO;
import com.eduhub.financeservice.service.FinanceService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/finance")
@Slf4j
public class FinanceController {
    private final FinanceService financeService;
    /**
     * Get all finances
     *
     * @return success or fail response of finances fetching
     */
    @GetMapping("")
    public ResponseEntity<CommonResponse> getAllFinanceDetails() {
        CommonResponse commonResponse = financeService.getAllFinanceDetails();
        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }

    /**
     * Get finance by finance id
     *
     * @param financeId - required data for get finance by id
     * @return success or fail response of get finance by id
     */
    @GetMapping("/{financeId}")
    public ResponseEntity<CommonResponse> getFinancesDetailsById(@PathVariable("financeId") @NotNull Long financeId) {
        CommonResponse commonResponse = financeService.getFinancesDetailsById(financeId);
        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }

    /**
     * Create finance
     *
     * @param financeDTO - required data for finance save
     * @return success or fail response of finance save
     */
    @PostMapping("")
    public ResponseEntity<CommonResponse> saveFinance(@Valid @RequestBody FinanceDTO financeDTO) {
        CommonResponse commonResponse = financeService.saveFinance(financeDTO);
        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }

    /**
     * Update finance
     *
     * @param financeDTO - required data for finance update
     * @return success or fail response of finance update
     */
    @PutMapping("")
    public ResponseEntity<CommonResponse> updateFinance(@Valid @RequestBody FinanceDTO financeDTO) {
        CommonResponse commonResponse = financeService.updateFinance(financeDTO);
        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }

    /**
     * Delete finance by id
     *
     * @param financeId - required data for delete finance by id
     * @return success or fail response of delete finance by id
     */
    @DeleteMapping("/{financeId}")
    public ResponseEntity<CommonResponse> deleteFinanceDetailsById(@PathVariable("financeId") @NotNull Long financeId) {
        CommonResponse commonResponse = financeService.deleteFinanceDetailsById(financeId);
        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }

    /**
     * Delete finances
     *
     * @return success or fail response of delete finances
     */
    @DeleteMapping("")
    public ResponseEntity<CommonResponse> deleteFinances() {
        CommonResponse commonResponse = financeService.deleteFinances();
        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }
}
