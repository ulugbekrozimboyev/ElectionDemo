package com.example.ElectionDemo.helpers;

import com.example.ElectionDemo.dto.Answer;
import com.example.ElectionDemo.dto.AnswerDto;
import com.example.ElectionDemo.dto.CandidateDto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * CandidateDaoHelper - singleton helper class for CandidateDao
 * <p>
 * Pros:
 * Thread safety is guaranteed
 * Client application can pass arguments
 * Lazy initialization achieved
 * Synchronization overhead is minimal and applicable only for first few threads when the variable is null.
 * <p>
 * Cons:
 * Extra if condition
 */
public class AnswerDaoHelper {
    private static volatile AnswerDaoHelper instance;
    private static final Object mutex = new Object();

    private AnswerDaoHelper() {
    }

    public static AnswerDaoHelper getInstance() {
        AnswerDaoHelper result = instance;
        if(result == null) {
            synchronized (mutex) {
                result = instance;
                if(result == null) instance = result = new AnswerDaoHelper();
            }
        }
        return result;
    }

    public List<AnswerDto> getUserAnswerDtos(Map<String, String[]> params, Long userId) {
        List<AnswerDto> answerDtos = new ArrayList<>();


        for (String id : params.keySet()) {
            AnswerDto answerDto = new AnswerDto();
            answerDto.setQuestionId(Long.valueOf(id));
            answerDto.setAnswer(Answer.valueOf(params.get(id)[0]));
            answerDto.setUserId(userId);
            answerDtos.add(answerDto);
        }
        return answerDtos;
    }
}
