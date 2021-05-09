package com.example.ElectionDemo.dao;

import com.example.ElectionDemo.dto.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AnswerDao {
    private static List<AnswerDto> answerDtos = new ArrayList<>();

    public static List<AnswerDto> findAll() {
        return answerDtos;
    }

    public static List<AnswerDto> save(List<AnswerDto> answerDto) {
        if(answerDtos.size() == 0) {
            AtomicLong i = new AtomicLong();
            answerDto.forEach(answer -> answer.setId(i.getAndIncrement()));
        } else {
            AtomicReference<Long> id = new AtomicReference<>(answerDtos.get(answerDtos.size() - 1).getId());
            answerDto.forEach(answer -> answer.setId(id.get() + 1));
        }
        answerDtos.addAll(answerDto);
        return answerDto;
    }

    public static List<StatisticsDto> getAnswerStatistics(List<CandidateDto> candidates, List<QuestionDto> questions) {
        List<StatisticsDto> statisticsDtos = new ArrayList<>();
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
}
