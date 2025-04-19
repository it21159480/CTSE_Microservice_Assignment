package com.eduhub.learnerservice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

//Enitity Class
@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "learner")
public class Learner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "learner_id")
    private Long learnerId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "phone")
    private String phone;
    @Column(name = "address")
    private String address;
    @Column(name = "city")
    private String city;
    @Column(name = "country")
    private String country;
}
