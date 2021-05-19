package com.example.ElectionDemo.dao;

import com.example.ElectionDemo.config.HibernateUtil;
import com.example.ElectionDemo.dto.*;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AnswerDao extends HibernateUtil {

    public static List<AnswerDto> findAll() {
        Session session = getSessionFactory().openSession();
        Query<com.example.ElectionDemo.entities.Answer> query = session.createQuery("select a from Answer a order by a.id", com.example.ElectionDemo.entities.Answer.class);
        return query.getResultList().stream().map(AnswerDao::convertToDto).collect(Collectors.toList());
    }

    public static List<AnswerDto> save(List<AnswerDto> answerDto) {
        Session session = getSessionFactory().openSession();

        for (AnswerDto dto : answerDto) {
            session.getTransaction().begin();
            session.saveOrUpdate(convertToEntity(dto));
            session.getTransaction().commit();
        }
        return answerDto;
    }

    public static List<StatisticsDto> getAnswerStatistics(List<CandidateDto> candidates, List<QuestionDto> questions) {
        List<StatisticsDto> statisticsDtos = new ArrayList<>();
        List<AnswerDto> answerDtos = findAll();
        for (CandidateDto candidate : candidates) {

            Map<Answer, AnswerCountDto> statistics = new HashMap<>();
            for (Answer answer : Answer.values()) {
                List<AnswerDto> collect = answerDtos.stream()
                        .filter(answerDto ->
                                answerDto.getAnswer().equals(answer) && answerDto.getUserId().equals(candidate.getId())).collect(Collectors.toList());
                List<QuestionDto> questionDtoList = questions.stream().
                        filter(questionDto ->
                                collect.stream()
                                        .anyMatch(answerDto -> answerDto.getQuestionId().equals(questionDto.getId())))
                        .collect(Collectors.toList());

                statistics.put(answer, new AnswerCountDto(questionDtoList, collect.size()));
            }
            statisticsDtos.add(new StatisticsDto(candidate, statistics));
        }
        return statisticsDtos;
    }

    private static AnswerDto convertToDto(com.example.ElectionDemo.entities.Answer answer) {
        return new AnswerDto(answer.getId(), answer.getQuestionId(), answer.getUserId(), answer.getAnswer());
    }

    private static com.example.ElectionDemo.entities.Answer convertToEntity(AnswerDto answer) {
        return new com.example.ElectionDemo.entities.Answer(answer.getId(), answer.getQuestionId(), answer.getUserId(), answer.getAnswer());
    }
}
