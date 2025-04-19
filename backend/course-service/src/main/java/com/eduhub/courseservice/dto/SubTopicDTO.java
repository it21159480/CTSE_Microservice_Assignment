package com.eduhub.courseservice.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class SubTopicDTO {
    private String title;
    private String video;
    private String slides;
    private String notes;
}
