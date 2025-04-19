package com.eduhub.courseservice.mapper;

import com.eduhub.courseservice.dto.QuizDTO;
import com.eduhub.courseservice.entity.Quiz;
import com.eduhub.courseservice.exception.ReferenceNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class QuizMapper {
    public Quiz dtoToDomain(QuizDTO dto, Quiz domain) {
        if (dto == null) {
            throw new ReferenceNotFoundException("The QuizDTO should not be null");
        }
        domain.setQuestion(dto.getQuestion());
        domain.setAnswers(dto.getAnswers());
        domain.setCorrectAnswer(dto.getCorrectAnswer());
        return domain;
    }

    public QuizDTO domainToDto(Quiz domain) {
        if (domain == null) {
            throw new ReferenceNotFoundException("The Quiz should not be null");
        }
        QuizDTO dto = new QuizDTO();
        dto.setQuizId(domain.getQuizId());
        dto.setQuestion(domain.getQuestion());
        dto.setAnswers(domain.getAnswers());
        dto.setCorrectAnswer(domain.getCorrectAnswer());
        return dto;
    }
}
