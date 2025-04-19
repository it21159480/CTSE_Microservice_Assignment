package com.eduhub.notificationservice.service.impl;

import com.eduhub.notificationservice.common.CommonResponse;
import com.eduhub.notificationservice.dto.NotificationDTO;
import com.eduhub.notificationservice.entity.Notification;
import com.eduhub.notificationservice.mapper.NotificationMapper;
import com.eduhub.notificationservice.repository.NotificationRepository;
import com.eduhub.notificationservice.service.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {
    private final NotificationRepository notificationRepository;
    private final NotificationMapper notificationMapper;

    @Override
    public CommonResponse getAllNotificationsDetails() {
        log.info("NotificationServiceImpl.getAllNotificationsDetails method accessed");
        CommonResponse commonResponse = new CommonResponse();
        List<NotificationDTO> notificationDTOS = new ArrayList<>();
        List<Notification> notifications = notificationRepository.findAll();
        notifications.forEach(notification ->  notificationDTOS.add(notificationMapper.domainToDto(notification)));
        if (notifications.isEmpty()) {
            commonResponse.setStatus(HttpStatus.OK);
            commonResponse.setData(new ArrayList<>());
            commonResponse.setMessage("Notification details list not available!");
            log.warn("Notification details not available. message :{}", commonResponse.getMessage());
            return commonResponse;
        }
        commonResponse.setStatus(HttpStatus.OK);
        commonResponse.setMessage("Notification details are fetching success!");
        commonResponse.setData(notificationDTOS);
        log.info("NotificationServiceImpl.getAllNotificationsDetails method end");
        return commonResponse;
    }

    @Override
    public CommonResponse getNotificationDetailsById(Long instructorId) {
        log.info("NotificationServiceImpl.getNotificationDetailsById method accessed");
        NotificationDTO notificationDTO;
        CommonResponse commonResponse = new CommonResponse();
        Optional<Notification> instructor = notificationRepository.findById(instructorId);
        if(instructor.isPresent()) {
            notificationDTO = notificationMapper.domainToDto(instructor.get());
        } else {
            commonResponse.setStatus(HttpStatus.OK);
            commonResponse.setData(new ArrayList<>());
            commonResponse.setMessage("Notification details is not available!");
            log.warn("Notification details not available. message : {} ", commonResponse.getMessage());
            return commonResponse;
        }
        commonResponse.setStatus(HttpStatus.OK);
        commonResponse.setMessage("Notification details is fetching success!");
        commonResponse.setData(notificationDTO);
        log.info("NotificationServiceImpl.getNotificationDetailsById method end");
        return commonResponse;
    }

    @Override
    public CommonResponse saveNotification(NotificationDTO notificationDTO) {
        log.info("NotificationServiceImpl.saveNotification method accessed");
        CommonResponse commonResponse = new CommonResponse();
        Optional<Notification> notification = notificationRepository.findById(notificationDTO.getInstructorId());
        if(notification.isPresent()){
            commonResponse.setStatus(HttpStatus.BAD_REQUEST);
            commonResponse.setMessage("Notification details already exist!");
            commonResponse.setData(notificationMapper.domainToDto(notification.get()));
            log.warn("Notification details not exist. message : {}", commonResponse.getMessage());
            return commonResponse;
        }
        Notification notificationSavedDetails = notificationRepository.save(notificationMapper.dtoToDomain(notificationDTO, new Notification()));
        commonResponse.setStatus(HttpStatus.CREATED);
        commonResponse.setMessage("Notification details saved success!");
        commonResponse.setData(notificationMapper.domainToDto(notificationSavedDetails));
        log.info("NotificationServiceImpl.saveNotification method end");
        return commonResponse;
    }

    @Override
    public CommonResponse updateNotification(NotificationDTO notificationDTO) {
        log.info("NotificationServiceImpl.updateNotification method accessed");
        CommonResponse commonResponse = new CommonResponse();
        Optional<Notification> notification = notificationRepository.findById(notificationDTO.getInstructorId());
        if(notification.isEmpty()) {
            commonResponse.setStatus(HttpStatus.BAD_REQUEST);
            commonResponse.setMessage("Notification details not available!");
            commonResponse.setData(new ArrayList<>());
            log.warn("Notification detail not available. message : {}", commonResponse.getMessage());
            return commonResponse;
        }
        Notification notificationUpdatedDetails = notificationRepository.save(notificationMapper.dtoToDomain(notificationDTO, notification.get()));
        commonResponse.setStatus(HttpStatus.OK);
        commonResponse.setMessage("Notification details is update success!");
        commonResponse.setData(notificationMapper.domainToDto(notificationUpdatedDetails));
        log.info("NotificationServiceImpl.updateNotification method end");
        return commonResponse;
    }

    @Override
    public CommonResponse deleteNotificationDetailsById(Long instructorId) {
        log.info("NotificationServiceImpl.deleteNotificationDetailsById method accessed");
        CommonResponse commonResponse = new CommonResponse();
        Optional<Notification> notification = notificationRepository.findById(instructorId);
        if(notification.isEmpty()) {
            commonResponse.setStatus(HttpStatus.BAD_REQUEST);
            commonResponse.setMessage("Delete notification details not available!");
            commonResponse.setData(new ArrayList<>());
            log.warn("Notification details not available. message : {}", commonResponse.getMessage());
            return commonResponse;
        }
        notificationRepository.deleteById(instructorId);
        commonResponse.setStatus(HttpStatus.OK);
        commonResponse.setMessage("Notification details is delete success!");
        commonResponse.setData(new ArrayList<>());
        log.info("NotificationServiceImpl.deleteNotificationDetailsById method end");
        return commonResponse;
    }

    @Override
    public CommonResponse deleteNotifications() {
        log.info("NotificationServiceImpl.deleteNotifications method accessed");
        CommonResponse commonResponse = new CommonResponse();
        List<Notification> notifications = notificationRepository.findAll();
        if(notifications.isEmpty()) {
            commonResponse.setStatus(HttpStatus.BAD_REQUEST);
            commonResponse.setMessage("Delete notifications details not available!");
            commonResponse.setData(new ArrayList<>());
            log.warn("Notification details not available. message : {}", commonResponse.getMessage());
            return commonResponse;
        }
        notificationRepository.deleteAll();
        commonResponse.setStatus(HttpStatus.OK);
        commonResponse.setMessage("Notification details is delete success!");
        commonResponse.setData(new ArrayList<>());
        log.info("NotificationServiceImpl.deleteNotifications method end");
        return commonResponse;
    }
}
