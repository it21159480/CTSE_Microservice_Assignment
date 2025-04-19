package com.eduhub.courseservice.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class MainTopicDTO {
    private Long mainTopicId;
    private String title;
    private String description;
    private List<SubTopicDTO> subtopics;
    private List<QuizDTO> quizzes;
}
