package com.eduhub.courseservice.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class CourseDTO {
    private Long courseId;
    private String title;
    private String titleImage;
    private List<MediaDTO> mediaDTOS;
    private ArrayList<String> outcomes;
    private String structure;
    private String description;
    private String status;
    private List<MainTopicDTO> mainTopics;
}
