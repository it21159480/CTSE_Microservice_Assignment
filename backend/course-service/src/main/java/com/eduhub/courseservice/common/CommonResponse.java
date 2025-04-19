package com.eduhub.courseservice.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CommonResponse {
    private HttpStatus status;
    private String message;
    private Timestamp timestamp;
    private Object data;
}
