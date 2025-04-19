package com.eduhub.courseservice.service.impl;

import com.eduhub.courseservice.common.CommonResponse;
import com.eduhub.courseservice.dto.CourseDTO;
import com.eduhub.courseservice.dto.MediaDTO;
import com.eduhub.courseservice.entity.Course;
import com.eduhub.courseservice.mapper.CourseMapper;
import com.eduhub.courseservice.mapper.MediaEntityMapper;
import com.eduhub.courseservice.repository.CourseRepository;
import com.eduhub.courseservice.service.CourseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;
    private final MediaEntityMapper mediaEntityMapper;

    @Override
    public CommonResponse getAllCourseDetails() {
        log.info("CourseServiceImpl.getAllCourseDetails method accessed");
        CommonResponse commonResponse = new CommonResponse();
        List<CourseDTO> courseDTOS = new ArrayList<>();
        List<Course> courses = courseRepository.findAll();
        courses.forEach(course ->  courseDTOS.add(courseMapper.domainToDto(course)));
        if (courses.isEmpty()) {
            commonResponse.setStatus(HttpStatus.OK);
            commonResponse.setData(new ArrayList<>());
            commonResponse.setMessage("Course details list not available!");
            log.warn("Course details not available. message :{}", commonResponse.getMessage());
            return commonResponse;
        }
        commonResponse.setStatus(HttpStatus.OK);
        commonResponse.setMessage("Course details are fetching success!");
        commonResponse.setData(courseDTOS);
        log.info("CourseServiceImpl.getAllCourseDetails method end");
        return commonResponse;
    }

    @Override
    public CommonResponse getCourseDetailsById(Long courseId) {
        log.info("CourseServiceImpl.getCourseDetailsById method accessed");
        CourseDTO courseDTO;
        CommonResponse commonResponse = new CommonResponse();
        Optional<Course> course = courseRepository.findById(courseId);
        if(course.isPresent()) {
            courseDTO = courseMapper.domainToDto(course.get());
        } else {
            commonResponse.setStatus(HttpStatus.OK);
            commonResponse.setData(new ArrayList<>());
            commonResponse.setMessage("Course details is not available!");
            log.warn("Course fetch details not available. message : {} ", commonResponse.getMessage());
            return commonResponse;
        }
        commonResponse.setStatus(HttpStatus.OK);
        commonResponse.setMessage("Course details is fetching success!");
        commonResponse.setData(courseDTO);
        log.info("CourseServiceImpl.getCourseDetailsById method end");
        return commonResponse;
    }

    @Override
    public CommonResponse saveCourse(CourseDTO courseDTO) throws IOException {
        log.info("CourseServiceImpl.saveCourse method accessed");
        CommonResponse commonResponse = new CommonResponse();
        Optional<Course> course = courseRepository.findById(courseDTO.getCourseId());
        if(course.isPresent()){
            commonResponse.setStatus(HttpStatus.BAD_REQUEST);
            commonResponse.setMessage("Course details already exist!");
            commonResponse.setData(courseMapper.domainToDto(course.get()));
            log.warn("Course save details not exist. message : {}", commonResponse.getMessage());
            return commonResponse;
        }
        Course courseSavedDetails = courseRepository.save(courseMapper.dtoToDomain(courseDTO, new Course()));
        commonResponse.setStatus(HttpStatus.CREATED);
        commonResponse.setMessage("Course details saved success!");
        commonResponse.setData(courseMapper.domainToDto(courseSavedDetails));
        log.info("CourseServiceImpl.saveCourse method end");
        return commonResponse;
    }

    @Override
    public CommonResponse updateCourse(CourseDTO courseDTO) throws IOException {
        log.info("CourseServiceImpl.updateCourse method accessed");
        CommonResponse commonResponse = new CommonResponse();
        Optional<Course> course = courseRepository.findById(courseDTO.getCourseId());
        if(course.isEmpty()) {
            commonResponse.setStatus(HttpStatus.BAD_REQUEST);
            commonResponse.setMessage("Course details not available!");
            commonResponse.setData(new ArrayList<>());
            log.warn("Course detail not available. message : {}", commonResponse.getMessage());
            return commonResponse;
        }
        Course courseUpdatedDetails = courseRepository.save(courseMapper.dtoToDomain(courseDTO, course.get()));
        commonResponse.setStatus(HttpStatus.OK);
        commonResponse.setMessage("Course details is update success!");
        commonResponse.setData(courseMapper.domainToDto(courseUpdatedDetails));
        log.info("CourseServiceImpl.updateCourse method end");
        return commonResponse;
    }

    @Override
    public CommonResponse deleteCourseDetailsById(Long courseId) {
        log.info("CourseServiceImpl.deleteCourseDetailsById method accessed");
        CommonResponse commonResponse = new CommonResponse();
        Optional<Course> course = courseRepository.findById(courseId);
        if(course.isEmpty()) {
            commonResponse.setStatus(HttpStatus.BAD_REQUEST);
            commonResponse.setMessage("Delete course details not available!");
            commonResponse.setData(new ArrayList<>());
            log.warn("Course details not available. message : {}", commonResponse.getMessage());
            return commonResponse;
        }
        courseRepository.deleteById(courseId);
        commonResponse.setStatus(HttpStatus.OK);
        commonResponse.setMessage("Course details is delete success!");
        commonResponse.setData(new ArrayList<>());
        log.info("CourseServiceImpl.deleteCourseDetailsById method end");
        return commonResponse;
    }

    @Override
    public CommonResponse deleteCourses() {
        log.info("CourseServiceImpl.deleteCourses method accessed");
        CommonResponse commonResponse = new CommonResponse();
        List<Course> course = courseRepository.findAll();
        if(course.isEmpty()) {
            commonResponse.setStatus(HttpStatus.BAD_REQUEST);
            commonResponse.setMessage("Delete course details not available!");
            commonResponse.setData(new ArrayList<>());
            log.warn("Course details for delete not available. message : {}", commonResponse.getMessage());
            return commonResponse;
        }
        courseRepository.deleteAll();
        commonResponse.setStatus(HttpStatus.OK);
        commonResponse.setMessage("Course details is delete success!");
        commonResponse.setData(new ArrayList<>());
        log.info("CourseServiceImpl.deleteCourses method end");
        return commonResponse;
    }

    @Override
    public CommonResponse saveCourseWithFile(CourseDTO courseDTO, List<MultipartFile> files) throws IOException {
        log.info("CourseServiceImpl.saveCourseWithFile method accessed");
        CommonResponse commonResponse = new CommonResponse();
        Optional<Course> course = courseRepository.findById(courseDTO.getCourseId());
        if(course.isPresent()){
            commonResponse.setStatus(HttpStatus.BAD_REQUEST);
            commonResponse.setMessage("Course details already exist!");
            commonResponse.setData(courseMapper.domainToDto(course.get()));
            log.warn("Course details not exist. message : {}", commonResponse.getMessage());
            return commonResponse;
        }
        List<MediaDTO> mediaDTOS = new ArrayList<>();
        files.forEach(file -> {
            try {
                if (file.getSize() > 10485760) {
                    throw new IllegalStateException("File size exceeds maximum allowed limit");
                }
                mediaDTOS.add(mediaEntityMapper.fileToDto(file, new MediaDTO()));
            } catch (IOException e) {
                throw new IllegalArgumentException(e);
            }
        });
        courseDTO.setMediaDTOS(mediaDTOS);
        Course courseSavedDetails = courseRepository.save(courseMapper.dtoToDomain(courseDTO, new Course()));
        commonResponse.setStatus(HttpStatus.CREATED);
        commonResponse.setMessage("Course details saved success!");
        commonResponse.setData(courseMapper.domainToDto(courseSavedDetails));
        log.info("CourseServiceImpl.saveCourseWithFile method end");
        return commonResponse;
    }
}
