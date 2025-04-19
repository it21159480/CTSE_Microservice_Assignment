package com.eduhub.notificationservice.repository;

import com.eduhub.notificationservice.entity.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NotificationRepository extends MongoRepository<Notification, Long> {
}
