package com.example.ElectionDemo.dao;

import com.example.ElectionDemo.dto.QuestionDto;

import java.util.*;

/**
 * Author: Ulug'bek Ro'zimboyev  <ulugbekrozimboyev@gmail.com>
 * Date: 5/1/2021 5:42 PM
 */
public class QuestionDao {
    public static final List<QuestionDto> questionList = new ArrayList<>(Arrays.asList(
        new QuestionDto(1L," This is a question one"),
        new QuestionDto(2L," This is a question two")
    ));

    public static List<QuestionDto> findAll() {
        return questionList;
    }

    public static void save(QuestionDto questionDto) {
        questionDto.setId((long) (questionList.size() + 1));
        questionList.add(questionDto);
    }

    public static void delete(Long id) {
        questionList.removeIf(questionDto -> Objects.equals(questionDto.getId(), id));
    }

    public static Optional<QuestionDto> findById(Long id) {
        return questionList.stream().filter(item -> Objects.equals(item.getId(), id)).findFirst();
    }

    public static void update(QuestionDto questionDto) {
        for (QuestionDto dto : questionList) {
            if (Objects.equals(dto.getId(), questionDto.getId())) {
                dto.setTitle(questionDto.getTitle());
            }
        }
    }
}
