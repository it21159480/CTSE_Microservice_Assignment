package com.eduhub.courseservice.mapper;

import com.eduhub.courseservice.dto.MediaDTO;
import com.eduhub.courseservice.entity.MediaEntity;
import com.eduhub.courseservice.exception.ReferenceNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Objects;

@Component
@Slf4j
@AllArgsConstructor
public class MediaEntityMapper {
    public MediaEntity dtoToDomain(MediaDTO dto, MediaEntity domain) throws IOException {
        if (dto == null) {
            throw new ReferenceNotFoundException("The MultipartFile should not be null");
        }
        domain.setContentType(dto.getContentType());
        domain.setData(dto.getData());
        domain.setFileName(dto.getFileName());
        return domain;
    }

    public MediaDTO fileToDto(MultipartFile file, MediaDTO dto) throws IOException {
        if (file == null) {
            throw new ReferenceNotFoundException("The MultipartFile should not be null");
        }
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        dto.setContentType(file.getContentType());
        dto.setData(file.getBytes());
        dto.setFileName(fileName);
        return dto;
    }

}
