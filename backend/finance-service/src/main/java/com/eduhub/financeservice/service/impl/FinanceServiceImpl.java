package com.eduhub.financeservice.service.impl;

import com.eduhub.financeservice.common.CommonResponse;
import com.eduhub.financeservice.dto.FinanceDTO;
import com.eduhub.financeservice.entity.Finance;
import com.eduhub.financeservice.mapper.FinanceMapper;
import com.eduhub.financeservice.repository.FinanceRepository;
import com.eduhub.financeservice.service.FinanceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class FinanceServiceImpl implements FinanceService {
    private final FinanceRepository financeRepository;
    private final FinanceMapper financeMapper;

    @Override
    public CommonResponse getAllFinanceDetails() {
        log.info("FinanceServiceImpl.getAllFinanceDetails method accessed");
        CommonResponse commonResponse = new CommonResponse();
        List<FinanceDTO> financeDTOS = new ArrayList<>();
        List<Finance> finances = financeRepository.findAll();
        finances.forEach(finance ->  financeDTOS.add(financeMapper.domainToDto(finance)));
        if (finances.isEmpty()) {
            commonResponse.setStatus(HttpStatus.OK);
            commonResponse.setData(new ArrayList<>());
            commonResponse.setMessage("Finance details list not available!");
            log.warn("Finance details not available. message :{}", commonResponse.getMessage());
            return commonResponse;
        }
        commonResponse.setStatus(HttpStatus.OK);
        commonResponse.setMessage("Finance details are fetching success!");
        commonResponse.setData(financeDTOS);
        log.info("FinanceServiceImpl.getAllFinanceDetails method end");
        return commonResponse;
    }

    @Override
    public CommonResponse getFinancesDetailsById(Long financeId) {
        log.info("FinanceServiceImpl.getFinancesDetailsById method accessed");
        FinanceDTO financeDTO;
        CommonResponse commonResponse = new CommonResponse();
        Optional<Finance> finance = financeRepository.findById(financeId);
        if(finance.isPresent()) {
            financeDTO = financeMapper.domainToDto(finance.get());
        } else {
            commonResponse.setStatus(HttpStatus.OK);
            commonResponse.setData(new ArrayList<>());
            commonResponse.setMessage("Finance details is not available!");
            log.warn("Finance details not available. message : {} ", commonResponse.getMessage());
            return commonResponse;
        }
        commonResponse.setStatus(HttpStatus.OK);
        commonResponse.setMessage("Finance details is fetching success!");
        commonResponse.setData(financeDTO);
        log.info("FinanceServiceImpl.getFinancesDetailsById method end");
        return commonResponse;
    }

    @Override
    public CommonResponse saveFinance(FinanceDTO financeDTO) {
        log.info("FinanceServiceImpl.saveFinance method accessed");
        CommonResponse commonResponse = new CommonResponse();
        Optional<Finance> finance = financeRepository.findById(financeDTO.getFinanceId());
        if(finance.isPresent()){
            commonResponse.setStatus(HttpStatus.BAD_REQUEST);
            commonResponse.setMessage("Finance details already exist!");
            commonResponse.setData(financeMapper.domainToDto(finance.get()));
            log.warn("Finance details not exist. message : {}", commonResponse.getMessage());
            return commonResponse;
        }
        Finance financeSavedDetails = financeRepository.save(financeMapper.dtoToDomain(financeDTO, new Finance()));
        commonResponse.setStatus(HttpStatus.CREATED);
        commonResponse.setMessage("Finance details saved success!");
        commonResponse.setData(financeMapper.domainToDto(financeSavedDetails));
        log.info("FinanceServiceImpl.saveFinance method end");
        return commonResponse;
    }

    @Override
    public CommonResponse updateFinance(FinanceDTO financeDTO) {
        log.info("FinanceServiceImpl.updateLearner method accessed");
        CommonResponse commonResponse = new CommonResponse();
        Optional<Finance> finance = financeRepository.findById(financeDTO.getFinanceId());
        if(finance.isEmpty()) {
            commonResponse.setStatus(HttpStatus.BAD_REQUEST);
            commonResponse.setMessage("Finance details not available!");
            commonResponse.setData(new ArrayList<>());
            log.warn("Finance detail not available. message : {}", commonResponse.getMessage());
            return commonResponse;
        }
        Finance financeUpdatedDetails = financeRepository.save(financeMapper.dtoToDomain(financeDTO, finance.get()));
        commonResponse.setStatus(HttpStatus.OK);
        commonResponse.setMessage("Finance details is update success!");
        commonResponse.setData(financeMapper.domainToDto(financeUpdatedDetails));
        log.info("FinanceServiceImpl.updateLearner method end");
        return commonResponse;
    }

    @Override
    public CommonResponse deleteFinanceDetailsById(Long financeId) {
        log.info("FinanceServiceImpl.deleteFinanceDetailsById method accessed");
        CommonResponse commonResponse = new CommonResponse();
        Optional<Finance> finance = financeRepository.findById(financeId);
        if(finance.isEmpty()) {
            commonResponse.setStatus(HttpStatus.BAD_REQUEST);
            commonResponse.setMessage("Delete finance details not available!");
            commonResponse.setData(new ArrayList<>());
            log.warn("Finance details not available. message : {}", commonResponse.getMessage());
            return commonResponse;
        }
        financeRepository.deleteById(financeId);
        commonResponse.setStatus(HttpStatus.OK);
        commonResponse.setMessage("Finance details is delete success!");
        commonResponse.setData(new ArrayList<>());
        log.info("FinanceServiceImpl.deleteFinanceDetailsById method end");
        return commonResponse;
    }

    @Override
    public CommonResponse deleteFinances() {
        log.info("FinanceServiceImpl.deleteLearners method accessed");
        CommonResponse commonResponse = new CommonResponse();
        List<Finance> finances = financeRepository.findAll();
        if(finances.isEmpty()) {
            commonResponse.setStatus(HttpStatus.BAD_REQUEST);
            commonResponse.setMessage("Delete finances details not available!");
            commonResponse.setData(new ArrayList<>());
            log.warn("Finance details not available. message : {}", commonResponse.getMessage());
            return commonResponse;
        }
        financeRepository.deleteAll();
        commonResponse.setStatus(HttpStatus.OK);
        commonResponse.setMessage("Finance details is delete success!");
        commonResponse.setData(new ArrayList<>());
        log.info("FinanceServiceImpl.deleteLearners method end");
        return commonResponse;
    }
}
