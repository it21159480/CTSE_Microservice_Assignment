package com.eduhub.courseservice.service;

import com.eduhub.courseservice.common.CommonResponse;
import com.eduhub.courseservice.dto.CourseDTO;
import com.eduhub.courseservice.dto.CourseHasEnrollmentDTO;

public interface CourseHasEnrollmentService {
    /**
     * Enroll course
     *
     * @param courseDTO - required data for course enroll
     * @return success or fail response of course enroll
     */
    CommonResponse saveCourseEnrollment(CourseHasEnrollmentDTO courseDTO);
}
