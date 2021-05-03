package com.example.ElectionDemo.dao;

import com.example.ElectionDemo.dto.QuestionDto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Author: Ulug'bek Ro'zimboyev  <ulugbekrozimboyev@gmail.com>
 * Date: 5/1/2021 5:42 PM
 */
public class QuestionDao {

    public static List<QuestionDto> questionList = new ArrayList<>(Arrays.asList(
        new QuestionDto(1l," This is a question one"),
        new QuestionDto(2l," This is a question two")
    ));

    public static List<QuestionDto> findAll() {
        return questionList;
    }

    public static void save(QuestionDto questionDto) {
        questionDto.setId((long) (questionList.size() + 1));
        questionList.add(questionDto);
    }

    public static void delete(Long id) {
        for (int i = 0; i < questionList.size(); i++) {
            if (questionList.get(i).getId() == id) {
                questionList.remove(i);
            }
        }
    }

    public static Optional<QuestionDto> findById(Long id) {
        Optional<QuestionDto> optional = questionList.stream().filter(item -> item.getId() == id).findFirst();
        return optional;
    }

    public static void update(QuestionDto questionDto) {
        for (int i = 0; i < questionList.size(); i++) {
            if (questionList.get(i).getId() == questionDto.getId()) {
                questionList.get(i).setTitle(questionDto.getTitle());
            }
        }
    }
}
