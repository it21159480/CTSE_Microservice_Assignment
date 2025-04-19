package com.eduhub.notificationservice.controller;

import com.eduhub.notificationservice.common.CommonResponse;
import com.eduhub.notificationservice.dto.NotificationDTO;
import com.eduhub.notificationservice.service.NotificationService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/notification")
@Slf4j
public class NotificationController {
    private final NotificationService notificationService;
    /**
     * Get all notifications
     *
     * @return success or fail response of notifications fetching
     */
    @GetMapping("")
    public ResponseEntity<CommonResponse> getAllNotificationsDetails() {
        CommonResponse commonResponse = notificationService.getAllNotificationsDetails();
        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }

    /**
     * Get notification by notifications id
     *
     * @param notificationId - required data for get notification by id
     * @return success or fail response of get notification by id
     */
    @GetMapping("/{notificationId}")
    public ResponseEntity<CommonResponse> getNotificationDetailsById(@PathVariable("notificationId") @NotNull Long notificationId) {
        CommonResponse commonResponse = notificationService.getNotificationDetailsById(notificationId);
        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }

    /**
     * Create notification
     *
     * @param notificationDTO - required data for notification save
     * @return success or fail response of notification save
     */
    @PostMapping("")
    public ResponseEntity<CommonResponse> saveNotification(@Valid @RequestBody NotificationDTO notificationDTO) {
        CommonResponse commonResponse = notificationService.saveNotification(notificationDTO);
        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }

    /**
     * Update notification
     *
     * @param notificationDTO - required data for notification update
     * @return success or fail response of notification update
     */
    @PutMapping("")
    public ResponseEntity<CommonResponse> updateNotification(@Valid @RequestBody NotificationDTO notificationDTO) {
        CommonResponse commonResponse = notificationService.updateNotification(notificationDTO);
        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }

    /**
     * Delete notification by id
     *
     * @param notificationId - required data for delete notification by id
     * @return success or fail response of delete notification by id
     */
    @DeleteMapping("/{notificationId}")
    public ResponseEntity<CommonResponse> deleteNotificationDetailsById(@PathVariable("notificationId") @NotNull Long notificationId) {
        CommonResponse commonResponse = notificationService.deleteNotificationDetailsById(notificationId);
        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }

    /**
     * Delete notifications
     *
     * @return success or fail response of delete notifications
     */
    @DeleteMapping("")
    public ResponseEntity<CommonResponse> deleteNotifications() {
        CommonResponse commonResponse = notificationService.deleteNotifications();
        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }
}
