package com.eduhub.notificationservice.service;

import com.eduhub.notificationservice.common.CommonResponse;
import com.eduhub.notificationservice.dto.NotificationDTO;

public interface NotificationService {
    /**
     * Get all notifications
     *
     * @return success or fail response of notifications fetching
     */
    CommonResponse getAllNotificationsDetails();

    /**
     * Get notification by notifications id
     *
     * @param notificationId - required data for get notification by id
     * @return success or fail response of get notification by id
     */
    CommonResponse getNotificationDetailsById(Long notificationId);

    /**
     * Create notification
     *
     * @param notificationDTO - required data for notification save
     * @return success or fail response of notification save
     */
    CommonResponse saveNotification(NotificationDTO notificationDTO);

    /**
     * Update notification
     *
     * @param notificationDTO - required data for notification update
     * @return success or fail response of notification update
     */
    CommonResponse updateNotification(NotificationDTO notificationDTO);

    /**
     * Delete notification by id
     *
     * @param notificationId - required data for delete notification by id
     * @return success or fail response of delete notification by id
     */
    CommonResponse deleteNotificationDetailsById(Long notificationId);

    /**
     * Delete notifications
     *
     * @return success or fail response of delete notifications
     */
    CommonResponse deleteNotifications();
}
