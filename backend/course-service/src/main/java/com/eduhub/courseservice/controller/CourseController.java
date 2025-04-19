package com.eduhub.courseservice.controller;

import com.eduhub.courseservice.common.CommonResponse;
import com.eduhub.courseservice.dto.CourseDTO;
import com.eduhub.courseservice.service.CourseService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/course")
@Slf4j
public class CourseController {
    private final CourseService courseService;
    /**
     * Get all course
     *
     * @return success or fail response of bodyMassIndex creation
     */
    @GetMapping("")
    public ResponseEntity<CommonResponse> getAllCourseDetails() {
        CommonResponse commonResponse = courseService.getAllCourseDetails();
        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }

    /**
     * Get course by course mediaId
     *
     * @param courseId - required data for get course by mediaId
     * @return success or fail response of get course by mediaId
     */
    @GetMapping("/{courseId}")
    public ResponseEntity<CommonResponse> getCourseDetailsById(@PathVariable("courseId") @NotNull Long courseId) {
        CommonResponse commonResponse = courseService.getCourseDetailsById(courseId);
        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }

    /**
     * Create course
     *
     * @param courseDTO - required data for course save
     * @return success or fail response of course save
     */
    @PostMapping("")
    public ResponseEntity<CommonResponse> saveCourse(@Valid @RequestBody CourseDTO courseDTO) throws IOException {
        CommonResponse commonResponse = courseService.saveCourse(courseDTO);
        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }

    /**
     * Create course with file
     *
     * @param courseDTO - required data for course with file save
     * @return success or fail response of course with file save
     */
    @PostMapping("/with-file")
    public ResponseEntity<CommonResponse> saveCourseWithFile(@Valid @RequestPart("data") String courseDTO, @RequestPart("files") List<MultipartFile> files) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        CourseDTO course = objectMapper.readValue(courseDTO, CourseDTO.class);
        CommonResponse commonResponse = courseService.saveCourseWithFile(course, files);
        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }

    /**
     * Update course
     *
     * @param courseDTO - required data for course update
     * @return success or fail response of course update
     */
    @PutMapping("")
    public ResponseEntity<CommonResponse> updateCourse(@Valid @RequestBody CourseDTO courseDTO) throws IOException {
        CommonResponse commonResponse = courseService.updateCourse(courseDTO);
        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }

    /**
     * Delete course by mediaId
     *
     * @param courseId - required data for delete course by mediaId
     * @return success or fail response of delete course by mediaId
     */
    @DeleteMapping("/{courseId}")
    public ResponseEntity<CommonResponse> deleteCourseDetailsById(@PathVariable("courseId") @NotNull Long courseId) {
        CommonResponse commonResponse = courseService.deleteCourseDetailsById(courseId);
        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }

    /**
     * Delete courses
     *
     * @return success or fail response of delete courses
     */
    @DeleteMapping("")
    public ResponseEntity<CommonResponse> deleteCourses() {
        CommonResponse commonResponse = courseService.deleteCourses();
        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }

}
