package com.eduhub.instructorservice.service.impl;

import com.eduhub.instructorservice.client.UserServiceClient;
import com.eduhub.instructorservice.common.CommonResponse;
import com.eduhub.instructorservice.dto.InstructorDTO;
import com.eduhub.instructorservice.dto.InstructorResponseDTO;
import com.eduhub.instructorservice.dto.authentication.response.MessageResponse;
import com.eduhub.instructorservice.dto.authentication.response.UserResponse;
import com.eduhub.instructorservice.entity.Instructor;
import com.eduhub.instructorservice.entity.InstructorHasUserInformation;
import com.eduhub.instructorservice.mapper.InstructorMapper;
import com.eduhub.instructorservice.repository.InstructorHasUserInformationRepository;
import com.eduhub.instructorservice.repository.InstructorRepository;
import com.eduhub.instructorservice.service.InstructorService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class InstructorServiceImpl implements InstructorService {
    private final InstructorRepository instructorRepository;
    private final InstructorMapper instructorMapper;
    private final UserServiceClient userServiceClient;
    private final InstructorHasUserInformationRepository instructorHasUserInformationRepository;

    @Override
    public CommonResponse getAllInstructorDetails() {
        log.info("InstructorServiceImpl.getAllInstructorDetails method accessed");
        CommonResponse commonResponse = new CommonResponse();
        List<InstructorDTO> instructorDTOS = new ArrayList<>();
        List<Instructor> instructors = instructorRepository.findAll();
        instructors.forEach(instructor ->  instructorDTOS.add(instructorMapper.domainToDto(instructor)));
        if (instructors.isEmpty()) {
            commonResponse.setStatus(HttpStatus.OK);
            commonResponse.setData(new ArrayList<>());
            commonResponse.setMessage("Instructor details list not available!");
            log.warn("Instructor details not available. message :{}", commonResponse.getMessage());
            return commonResponse;
        }
        commonResponse.setStatus(HttpStatus.OK);
        commonResponse.setMessage("Instructor details are fetching success!");
        commonResponse.setData(instructorDTOS);
        log.info("InstructorServiceImpl.getAllInstructorDetails method end");
        return commonResponse;
    }

    @Override
    public CommonResponse getInstructorsDetailsById(Long instructorId) {
        log.info("InstructorServiceImpl.getInstructorsDetailsById method accessed");
        InstructorDTO instructorDTO;
        CommonResponse commonResponse = new CommonResponse();
        Optional<Instructor> instructor = instructorRepository.findById(instructorId);
        if(instructor.isPresent()) {
            instructorDTO = instructorMapper.domainToDto(instructor.get());
        } else {
            commonResponse.setStatus(HttpStatus.OK);
            commonResponse.setData(new ArrayList<>());
            commonResponse.setMessage("Instructor details is not available!");
            log.warn("Instructor details not available. message : {} ", commonResponse.getMessage());
            return commonResponse;
        }
        commonResponse.setStatus(HttpStatus.OK);
        commonResponse.setMessage("Instructor details is fetching success!");
        commonResponse.setData(instructorDTO);
        log.info("InstructorServiceImpl.getInstructorsDetailsById method end");
        return commonResponse;
    }

    @Override
    public CommonResponse saveInstructor(InstructorDTO instructorDTO) {
        log.info("InstructorServiceImpl.saveInstructor method accessed");
        CommonResponse commonResponse = new CommonResponse();
        ObjectMapper objectMapper = new ObjectMapper();
        InstructorResponseDTO instructorResponseDTO = new InstructorResponseDTO();
        Optional<Instructor> instructor = instructorRepository.findById(instructorDTO.getInstructorId());
        if(instructor.isPresent()){
            commonResponse.setStatus(HttpStatus.BAD_REQUEST);
            commonResponse.setMessage("Instructor details already exist!");
            commonResponse.setData(instructorMapper.domainToDto(instructor.get()));
            log.warn("Instructor details not exist. message : {}", commonResponse.getMessage());
            return commonResponse;
        }
        MessageResponse userResponse = userServiceClient.registerUser(instructorDTO.getSignupRequest()).getBody();
        assert userResponse != null;
        UserResponse userObjectResponse = objectMapper.convertValue(userResponse.getData(), UserResponse.class);
        Instructor instructorSavedDetails = new Instructor();
        InstructorHasUserInformation instructorHasUserInformation = new InstructorHasUserInformation();
        if (userResponse.getData() != null) {
            instructorSavedDetails = instructorRepository.save(instructorMapper.dtoToDomain(instructorDTO, new Instructor()));
            instructorHasUserInformation.setUserId(userObjectResponse.getId());
            instructorHasUserInformation.setCreatedDate(LocalDateTime.now());
            instructorHasUserInformation.setInstructor(instructorSavedDetails);
            instructorHasUserInformationRepository.save(instructorHasUserInformation);
        }
        instructorResponseDTO.setInstructor(instructorSavedDetails);
        instructorResponseDTO.setUserResponse(userObjectResponse);
        instructorResponseDTO.setInstructorHasUserInformation(instructorHasUserInformation);
        commonResponse.setStatus(HttpStatus.CREATED);
        commonResponse.setMessage("Instructor details saved success!");
        commonResponse.setData(instructorResponseDTO);
        log.info("InstructorServiceImpl.saveInstructor method end");
        return commonResponse;
    }

    @Override
    public CommonResponse updateInstructor(InstructorDTO instructorDTO) {
        log.info("InstructorServiceImpl.updateInstructor method accessed");
        CommonResponse commonResponse = new CommonResponse();
        Optional<Instructor> instructor = instructorRepository.findById(instructorDTO.getInstructorId());
        if(instructor.isEmpty()) {
            commonResponse.setStatus(HttpStatus.BAD_REQUEST);
            commonResponse.setMessage("Instructor details not available!");
            commonResponse.setData(new ArrayList<>());
            log.warn("Instructor detail not available. message : {}", commonResponse.getMessage());
            return commonResponse;
        }
        Instructor instructorUpdatedDetails = instructorRepository.save(instructorMapper.dtoToDomain(instructorDTO, instructor.get()));
        commonResponse.setStatus(HttpStatus.OK);
        commonResponse.setMessage("Instructor details is update success!");
        commonResponse.setData(instructorMapper.domainToDto(instructorUpdatedDetails));
        log.info("InstructorServiceImpl.updateInstructor method end");
        return commonResponse;
    }

    @Override
    public CommonResponse deleteInstructorDetailsById(Long instructorId) {
        log.info("InstructorServiceImpl.deleteInstructorDetailsById method accessed");
        CommonResponse commonResponse = new CommonResponse();
        Optional<Instructor> instructor = instructorRepository.findById(instructorId);
        if(instructor.isEmpty()) {
            commonResponse.setStatus(HttpStatus.BAD_REQUEST);
            commonResponse.setMessage("Delete instructor details not available!");
            commonResponse.setData(new ArrayList<>());
            log.warn("Instructor details not available. message : {}", commonResponse.getMessage());
            return commonResponse;
        }
        instructorRepository.deleteById(instructorId);
        commonResponse.setStatus(HttpStatus.OK);
        commonResponse.setMessage("Instructor details is delete success!");
        commonResponse.setData(new ArrayList<>());
        log.info("InstructorServiceImpl.deleteInstructorDetailsById method end");
        return commonResponse;
    }

    @Override
    public CommonResponse deleteInstructors() {
        log.info("InstructorServiceImpl.deleteInstructors method accessed");
        CommonResponse commonResponse = new CommonResponse();
        List<Instructor> instructors = instructorRepository.findAll();
        if(instructors.isEmpty()) {
            commonResponse.setStatus(HttpStatus.BAD_REQUEST);
            commonResponse.setMessage("Delete instructors details not available!");
            commonResponse.setData(new ArrayList<>());
            log.warn("Instructor details not available. message : {}", commonResponse.getMessage());
            return commonResponse;
        }
        instructorRepository.deleteAll();
        commonResponse.setStatus(HttpStatus.OK);
        commonResponse.setMessage("Instructor details is delete success!");
        commonResponse.setData(new ArrayList<>());
        log.info("InstructorServiceImpl.deleteInstructors method end");
        return commonResponse;
    }
}
