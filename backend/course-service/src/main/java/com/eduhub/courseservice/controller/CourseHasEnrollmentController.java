package com.eduhub.courseservice.controller;

import com.eduhub.courseservice.common.CommonResponse;
import com.eduhub.courseservice.dto.CourseDTO;
import com.eduhub.courseservice.dto.CourseHasEnrollmentDTO;
import com.eduhub.courseservice.entity.CourseHasEnrollment;
import com.eduhub.courseservice.service.CourseHasEnrollmentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@AllArgsConstructor
@RestController
@RequestMapping("/api/courseHasEnrollment")
@Slf4j
public class CourseHasEnrollmentController {
    private final CourseHasEnrollmentService courseHasEnrollmentService;
    /**
     * Enroll course
     *
     * @param courseDTO - required data for course enroll
     * @return success or fail response of course enroll
     */
    @PostMapping("")
    public ResponseEntity<CommonResponse> saveCourseEnrollment(@Valid @RequestBody CourseHasEnrollmentDTO courseDTO) throws IOException {
        CommonResponse commonResponse = courseHasEnrollmentService.saveCourseEnrollment(courseDTO);
        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }

}
