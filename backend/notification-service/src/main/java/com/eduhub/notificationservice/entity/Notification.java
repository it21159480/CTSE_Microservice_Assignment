package com.eduhub.notificationservice.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@RequiredArgsConstructor
@Document
public class Notification {
    @Id
    private Long instructorId;
    @Field
    private String firstName;
    @Field
    private String lastName;
    @Field
    private String phone;
    @Field
    private String address;
    @Field
    private String city;
    @Field
    private String country;
    @Field
    private String degreeName;
    @Field
    private String fieldOfStudy;
    @Field
    private String yearsOfExperience;
}
