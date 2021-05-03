package com.example.ElectionDemo.dto;

import lombok.Data;

/**
 * Author: Ulug'bek Ro'zimboyev  <ulugbekrozimboyev@gmail.com>
 * Date: 5/1/2021 5:31 PM
 */
@Data
public class QuestionDto {
    private Long id;
    private String title;
    private Answer answer;

    public QuestionDto(long id, String title) {
        this.id = id;
        this.title = title;
    }

    public QuestionDto() {
    }
}
