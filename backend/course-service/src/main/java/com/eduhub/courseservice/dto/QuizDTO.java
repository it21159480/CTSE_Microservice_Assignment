package com.eduhub.courseservice.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@RequiredArgsConstructor
public class QuizDTO {
    private Long quizId;
    private String question;
    private ArrayList<String> answers;
    private int correctAnswer;
}
