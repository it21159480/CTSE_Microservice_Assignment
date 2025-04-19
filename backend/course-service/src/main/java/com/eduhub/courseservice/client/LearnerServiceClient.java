package com.eduhub.courseservice.client;

import com.eduhub.courseservice.common.CommonResponse;
import feign.Headers;
import jakarta.validation.constraints.NotNull;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "LEARNER-SERVICE")
@Headers({"Content-Type: application/json"})
public interface LearnerServiceClient {
    /**
     * Get learner and user by learner id
     *
     * @param learnerId - required data for get learner and user by id
     * @return success or fail response of get learner and user by id
     */
    @GetMapping("/learnerWithUser")
    public ResponseEntity<CommonResponse> getLearnersAndUserDetailsById(@RequestParam("learnerId") @NotNull Long learnerId);
}
