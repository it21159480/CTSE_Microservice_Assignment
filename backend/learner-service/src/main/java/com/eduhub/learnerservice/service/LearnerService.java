package com.eduhub.learnerservice.service;

import com.eduhub.learnerservice.common.CommonResponse;
import com.eduhub.learnerservice.dto.LearnerDTO;
import com.eduhub.learnerservice.dto.authentication.request.LoginRequest;
import com.eduhub.learnerservice.dto.authentication.response.JwtResponse;

public interface LearnerService {
    /**
     * Get all learners
     *
     * @return success or fail response of learners fetching
     */
    CommonResponse getAllLearnerDetails();

    /**
     * Get course by learner id
     *
     * @param learnerId - required data for get learner by id
     * @return success or fail response of get learner by id
     */
    CommonResponse getLearnersDetailsById(Long learnerId);

    /**
     * Create learner
     *
     * @param learnerDTO - required data for learner save
     * @return success or fail response of learner save
     */
    CommonResponse saveLearner(LearnerDTO learnerDTO);

    /**
     * Update learner
     *
     * @param learnerDTO - required data for learner update
     * @return success or fail response of learner update
     */
    CommonResponse updateLearner(LearnerDTO learnerDTO);

    /**
     * Delete learner by id
     *
     * @param learnerId - required data for delete learner by id
     * @return success or fail response of delete learner by id
     */
    CommonResponse deleteLearnerDetailsById(Long learnerId);

    /**
     * Delete learners
     *
     * @return success or fail response of delete learners
     */
    CommonResponse deleteLearners();

    JwtResponse authenticateUserDetails(LoginRequest loginRequest);

    CommonResponse getLearnersAndUserDetailsById(Long learnerId);
}
