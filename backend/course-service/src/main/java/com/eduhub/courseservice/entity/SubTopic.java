package com.eduhub.courseservice.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class SubTopic {
    private String title;
    private String video;
    private String slides;
    private String notes;
}
