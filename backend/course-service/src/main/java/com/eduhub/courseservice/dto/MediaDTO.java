package com.eduhub.courseservice.dto;

import com.eduhub.courseservice.entity.Course;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class MediaDTO {
    private Long mediaId;
    private String fileName;
    private String contentType;
    private byte[] data;
}
