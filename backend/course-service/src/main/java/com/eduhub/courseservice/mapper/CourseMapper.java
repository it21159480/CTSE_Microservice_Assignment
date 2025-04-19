package com.eduhub.courseservice.mapper;

import com.eduhub.courseservice.dto.CourseDTO;
import com.eduhub.courseservice.dto.MainTopicDTO;
import com.eduhub.courseservice.entity.Course;
import com.eduhub.courseservice.entity.MainTopic;
import com.eduhub.courseservice.entity.MediaEntity;
import com.eduhub.courseservice.exception.ReferenceNotFoundException;
import com.eduhub.courseservice.repository.MainTopicRepository;
import com.eduhub.courseservice.repository.MediaRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
@AllArgsConstructor
public class CourseMapper {
    private final MainTopicRepository mainTopicRepository;
    private final MainTopicMapper mainTopicMapper;
    private final MediaEntityMapper mediaEntityMapper;
    private final MediaRepository mediaRepository;
    public Course dtoToDomain(CourseDTO dto, Course domain) throws IOException {
        if (dto == null) {
            throw new ReferenceNotFoundException("The DoctorDTO should not be null");
        }
        domain.setTitle(dto.getTitle());
        domain.setTitleImage(dto.getTitleImage());
        List<MediaEntity> mediaEntities = new ArrayList<>();
        dto.getMediaDTOS().forEach(media -> {
            try {
                mediaEntities.add(mediaRepository.save(mediaEntityMapper.dtoToDomain(media, new MediaEntity())));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        domain.setMediaEntity(mediaEntities);
        domain.setOutcomes(dto.getOutcomes());
        domain.setStructure(dto.getStructure());
        domain.setDescription(dto.getDescription());
        domain.setStatus(dto.getStatus());
        ArrayList<MainTopic> mainTopics = new ArrayList<>();
        dto.getMainTopics().
                forEach(mainTopicDTO ->
                        mainTopics.add(mainTopicMapper.dtoToDomain(mainTopicDTO, new MainTopic())));
        List<MainTopic> mainSaveTopics = mainTopicRepository.saveAll(mainTopics);
        domain.setMainTopics(mainSaveTopics);
        return domain;
    }

    public CourseDTO domainToDto(Course domain) {
        if (domain == null) {
            throw new ReferenceNotFoundException("The Course should not be null");
        }
        CourseDTO dto = new CourseDTO();
        dto.setCourseId(domain.getCourseId());
        dto.setTitle(domain.getTitle());
        dto.setTitleImage(domain.getTitleImage());
//        dto.setFile(domain.getMediaEntity());
        dto.setOutcomes(domain.getOutcomes());
        dto.setStructure(domain.getStructure());
        dto.setDescription(domain.getDescription());
        dto.setStatus(domain.getStatus());
        List<MainTopicDTO> mainTopicDTOS = new ArrayList<>();
        domain.getMainTopics().forEach(mainTopic -> mainTopicDTOS.add(mainTopicMapper.domainToDto(mainTopic)));
        dto.setMainTopics(mainTopicDTOS);
        return dto;
    }
}
