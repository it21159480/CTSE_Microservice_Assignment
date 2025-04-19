package com.eduhub.courseservice.service.impl;

import com.eduhub.courseservice.common.CommonResponse;
import com.eduhub.courseservice.dto.CourseHasEnrollmentDTO;
import com.eduhub.courseservice.entity.Course;
import com.eduhub.courseservice.entity.CourseHasEnrollment;
import com.eduhub.courseservice.mapper.CourseHasEnrollmentMapper;
import com.eduhub.courseservice.repository.CourseHasEnrollmentRepository;
import com.eduhub.courseservice.service.CourseHasEnrollmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class CourseHasEnrollmentServiceImpl implements CourseHasEnrollmentService {
    private final CourseHasEnrollmentRepository courseHasEnrollmentRepository;
    private final CourseHasEnrollmentMapper courseHasEnrollmentMapper;
    @Override
    public CommonResponse saveCourseEnrollment(CourseHasEnrollmentDTO courseHasEnrollmentDTO) {
        log.info("CourseHasEnrollmentServiceImpl.saveCourseEnrollment method accessed");
        CommonResponse commonResponse = new CommonResponse();
        Optional<CourseHasEnrollment> courseHasEnrollment = courseHasEnrollmentRepository.findById(courseHasEnrollmentDTO.getCourseHasEnrollmentId());
        if(courseHasEnrollment.isPresent()){
            commonResponse.setStatus(HttpStatus.BAD_REQUEST);
            commonResponse.setMessage("Course details already exist!");
            commonResponse.setData(courseHasEnrollmentMapper.domainToDto(courseHasEnrollment.get()));
            log.warn("Course save details not exist. message : {}", commonResponse.getMessage());
            return commonResponse;
        }
        CourseHasEnrollment courseSavedDetails = courseHasEnrollmentRepository.save(courseHasEnrollmentMapper.dtoToDomain(courseHasEnrollmentDTO, new CourseHasEnrollment()));
        commonResponse.setStatus(HttpStatus.CREATED);
        commonResponse.setMessage("Course details saved success!");
        commonResponse.setData(courseHasEnrollmentMapper.domainToDto(courseSavedDetails));
        log.info("CourseHasEnrollmentServiceImpl.saveCourseEnrollment method end");
        return commonResponse;
    }
}
