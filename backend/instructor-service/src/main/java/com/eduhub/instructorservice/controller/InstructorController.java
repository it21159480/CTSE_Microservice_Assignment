package com.eduhub.instructorservice.controller;

import com.eduhub.instructorservice.common.CommonResponse;
import com.eduhub.instructorservice.dto.InstructorDTO;
import com.eduhub.instructorservice.service.InstructorService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/instructor")
@Slf4j
public class InstructorController {
    private final InstructorService instructorService;
    /**
     * Get all instructors
     *
     * @return success or fail response of instructors fetching
     */
    @GetMapping("")
    public ResponseEntity<CommonResponse> getAllInstructorDetails() {
        CommonResponse commonResponse = instructorService.getAllInstructorDetails();
        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }

    /**
     * Get instructor by instructor id
     *
     * @param instructorId - required data for get instructor by id
     * @return success or fail response of get instructor by id
     */
    @GetMapping("/{instructorId}")
    public ResponseEntity<CommonResponse> getInstructorsDetailsById(@PathVariable("instructorId") @NotNull Long instructorId) {
        CommonResponse commonResponse = instructorService.getInstructorsDetailsById(instructorId);
        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }

    /**
     * Create instructor
     *
     * @param instructorDTO - required data for instructor save
     * @return success or fail response of instructor save
     */
    @PostMapping("")
    public ResponseEntity<CommonResponse> saveInstructor(@Valid @RequestBody InstructorDTO instructorDTO) {
        CommonResponse commonResponse = instructorService.saveInstructor(instructorDTO);
        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }

    /**
     * Update instructor
     *
     * @param instructorDTO - required data for instructor update
     * @return success or fail response of instructor update
     */
    @PutMapping("")
    public ResponseEntity<CommonResponse> updateInstructor(@Valid @RequestBody InstructorDTO instructorDTO) {
        CommonResponse commonResponse = instructorService.updateInstructor(instructorDTO);
        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }

    /**
     * Delete instructor by id
     *
     * @param instructorId - required data for delete instructor by id
     * @return success or fail response of delete instructor by id
     */
    @DeleteMapping("/{instructorId}")
    public ResponseEntity<CommonResponse> deleteInstructorDetailsById(@PathVariable("instructorId") @NotNull Long instructorId) {
        CommonResponse commonResponse = instructorService.deleteInstructorDetailsById(instructorId);
        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }

    /**
     * Delete instructors
     *
     * @return success or fail response of delete instructors
     */
    @DeleteMapping("")
    public ResponseEntity<CommonResponse> deleteInstructors() {
        CommonResponse commonResponse = instructorService.deleteInstructors();
        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }
}
