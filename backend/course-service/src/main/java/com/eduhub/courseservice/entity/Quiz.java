package com.eduhub.courseservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "quiz")
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "quiz_id")
    private Long quizId;
    @Column(name = "question")
    private String question;
    @Column(name = "answers")
    private ArrayList<String> answers;
    @Column(name = "correctAnswer")
    private int correctAnswer;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "mainTopic")
    private MainTopic mainTopic;
}
