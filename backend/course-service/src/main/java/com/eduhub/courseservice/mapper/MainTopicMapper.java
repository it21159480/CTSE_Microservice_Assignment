package com.eduhub.courseservice.mapper;

import com.eduhub.courseservice.dto.MainTopicDTO;
import com.eduhub.courseservice.dto.QuizDTO;
import com.eduhub.courseservice.entity.MainTopic;
import com.eduhub.courseservice.entity.Quiz;
import com.eduhub.courseservice.exception.ReferenceNotFoundException;
import com.eduhub.courseservice.repository.QuizRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
@AllArgsConstructor
public class MainTopicMapper {
    private final QuizRepository quizRepository;
    private final QuizMapper quizMapper;
    public MainTopic dtoToDomain(MainTopicDTO dto, MainTopic domain) {
        if (dto == null) {
            throw new ReferenceNotFoundException("The MainTopicDTO should not be null");
        }
        domain.setTitle(dto.getTitle());
        domain.setDescription(dto.getDescription());
        List<Quiz> quizzes = new ArrayList<>();
        dto.getQuizzes().forEach(quizDTO -> quizzes.add(quizMapper.dtoToDomain(quizDTO, new Quiz())));
        List<Quiz> quizSaveList = quizRepository.saveAll(quizzes);
        domain.setQuizzes(quizSaveList);
        return domain;
    }

    public MainTopicDTO domainToDto(MainTopic domain) {
        if (domain == null) {
            throw new ReferenceNotFoundException("The MainTopic should not be null");
        }
        MainTopicDTO dto = new MainTopicDTO();
        dto.setMainTopicId(domain.getMainTopicId());
        dto.setTitle(domain.getTitle());
        dto.setDescription(domain.getDescription());
        List<QuizDTO> quizList = new ArrayList<>();
        domain.getQuizzes().forEach(quiz -> quizList.add(quizMapper.domainToDto(quiz)));
        dto.setQuizzes(quizList);
        return dto;
    }
}
