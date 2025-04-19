package com.eduhub.instructorservice.service;

import com.eduhub.instructorservice.common.CommonResponse;
import com.eduhub.instructorservice.dto.InstructorDTO;

public interface InstructorService {
    /**
     * Get all instructors
     *
     * @return success or fail response of instructors fetching
     */
    CommonResponse getAllInstructorDetails();

    /**
     * Get instructor by instructor id
     *
     * @param instructorId - required data for get instructor by id
     * @return success or fail response of get instructor by id
     */
    CommonResponse getInstructorsDetailsById(Long instructorId);

    /**
     * Create instructor
     *
     * @param instructorDTO - required data for instructor save
     * @return success or fail response of instructor save
     */
    CommonResponse saveInstructor(InstructorDTO instructorDTO);

    /**
     * Update instructor
     *
     * @param instructorDTO - required data for instructor update
     * @return success or fail response of instructor update
     */
    CommonResponse updateInstructor(InstructorDTO instructorDTO);

    /**
     * Delete instructor by id
     *
     * @param instructorId - required data for delete instructor by id
     * @return success or fail response of delete instructor by id
     */
    CommonResponse deleteInstructorDetailsById(Long instructorId);

    /**
     * Delete instructors
     *
     * @return success or fail response of delete instructors
     */
    CommonResponse deleteInstructors();
}
