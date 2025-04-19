package com.eduhub.learnerservice.controller;

import com.eduhub.learnerservice.common.CommonResponse;
import com.eduhub.learnerservice.dto.LearnerDTO;
import com.eduhub.learnerservice.dto.authentication.request.LoginRequest;
import com.eduhub.learnerservice.dto.authentication.response.JwtResponse;
import com.eduhub.learnerservice.service.LearnerService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/learner")
@Slf4j
@CrossOrigin("*")
public class LearnerController {
    private final LearnerService learnerService;
    /**
     * Get all learners
     *
     * @return success or fail response of learners fetching
     */
    @GetMapping("")
    public ResponseEntity<CommonResponse> getAllLearnerDetails() {
        CommonResponse commonResponse = learnerService.getAllLearnerDetails();
        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }

    /**
     * Get course by learner id
     *
     * @param learnerId - required data for get learner by id
     * @return success or fail response of get learner by id
     */
    @GetMapping("/{learnerId}")
    public ResponseEntity<CommonResponse> getLearnersDetailsById(@PathVariable("learnerId") @NotNull Long learnerId) {
        CommonResponse commonResponse = learnerService.getLearnersDetailsById(learnerId);
        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }

    /**
     * Create learner
     *
     * @param learnerDTO - required data for learner save
     * @return success or fail response of learner save
     */
    @PostMapping("")
    public ResponseEntity<CommonResponse> saveLearner(@Valid @RequestBody LearnerDTO learnerDTO) {
        CommonResponse commonResponse = learnerService.saveLearner(learnerDTO);
        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }

    /**
     * Update learner
     *
     * @param learnerDTO - required data for learner update
     * @return success or fail response of learner update
     */
    @PutMapping("")
    public ResponseEntity<CommonResponse> updateLearner(@Valid @RequestBody LearnerDTO learnerDTO) {
        CommonResponse commonResponse = learnerService.updateLearner(learnerDTO);
        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }

    /**
     * Delete learner by id
     *
     * @param learnerId - required data for delete learner by id
     * @return success or fail response of delete learner by id
     */
    @DeleteMapping("/{learnerId}")
    public ResponseEntity<CommonResponse> deleteLearnerDetailsById(@PathVariable("learnerId") @NotNull Long learnerId) {
        CommonResponse commonResponse = learnerService.deleteLearnerDetailsById(learnerId);
        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }

    /**
     * Delete learners
     *
     * @return success or fail response of delete learners
     */
    @DeleteMapping("")
    public ResponseEntity<CommonResponse> deleteLearners() {
        CommonResponse commonResponse = learnerService.deleteLearners();
        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }

    @PostMapping("/signin")
    public ResponseEntity<JwtResponse> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        JwtResponse jwtResponse = learnerService.authenticateUserDetails(loginRequest);
        return new ResponseEntity<>(jwtResponse, HttpStatus.OK);
    }

    /**
     * Get learner and user by learner id
     *
     * @param learnerId - required data for get learner and user by id
     * @return success or fail response of get learner and user by id
     */
    @GetMapping("/learnerWithUser")
    public ResponseEntity<CommonResponse> getLearnersAndUserDetailsById(@RequestParam("learnerId") @NotNull Long learnerId) {
        CommonResponse commonResponse = learnerService.getLearnersAndUserDetailsById(learnerId);
        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }


}
