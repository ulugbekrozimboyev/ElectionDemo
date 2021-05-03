package com.example.ElectionDemo.dao;

import com.example.ElectionDemo.dto.QuestionDto;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Ulug'bek Ro'zimboyev  <ulugbekrozimboyev@gmail.com>
 * Date: 5/1/2021 5:42 PM
 */
public class MainDao {

    public static List<QuestionDto> getQuestionList() {
        // TODO get from DB
        List<QuestionDto> questionList = new ArrayList<>();
        questionList.add(new QuestionDto(1," This is a question one"));
        questionList.add(new QuestionDto(2," This is a question two"));

        return questionList;
    }
}
