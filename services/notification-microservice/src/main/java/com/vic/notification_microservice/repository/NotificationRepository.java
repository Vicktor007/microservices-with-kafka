package com.vic.notification_microservice.repository;

import com.vic.notification_microservice.model.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NotificationRepository extends MongoRepository<Notification, String> {
}
