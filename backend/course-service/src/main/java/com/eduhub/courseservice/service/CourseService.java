package com.eduhub.courseservice.service;

import com.eduhub.courseservice.common.CommonResponse;
import com.eduhub.courseservice.dto.CourseDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface CourseService {
    /**
     * Get all course
     *
     * @return success or fail response of bodyMassIndex creation
     */
    CommonResponse getAllCourseDetails();

    /**
     * Get course by course mediaId
     *
     * @param courseId - required data for get course by mediaId
     * @return success or fail response of get course by mediaId
     */
    CommonResponse getCourseDetailsById(Long courseId);

    /**
     * Create course
     *
     * @param courseDTO - required data for course save
     * @return success or fail response of course save
     */
    CommonResponse saveCourse(CourseDTO courseDTO) throws IOException;

    /**
     * Update course
     *
     * @param courseDTO - required data for course update
     * @return success or fail response of course update
     */
    CommonResponse updateCourse(CourseDTO courseDTO) throws IOException;

    /**
     * Delete course by mediaId
     *
     * @param courseId - required data for delete course by mediaId
     * @return success or fail response of delete course by mediaId
     */
    CommonResponse deleteCourseDetailsById(Long courseId);

    /**
     * Delete courses
     *
     * @return success or fail response of delete courses
     */
    CommonResponse deleteCourses();

    /**
     * Create course with file
     *
     * @param courseDTO - required data for course with file save
     * @return success or fail response of course with file save
     */
    CommonResponse saveCourseWithFile(CourseDTO courseDTO, List<MultipartFile> files) throws IOException;
}
