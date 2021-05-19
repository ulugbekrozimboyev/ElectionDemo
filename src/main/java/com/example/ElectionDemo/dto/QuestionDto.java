package com.example.ElectionDemo.dto;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Author: Ulug'bek Ro'zimboyev  <ulugbekrozimboyev@gmail.com>
 * Date: 5/1/2021 5:31 PM
 */
@Data
@Entity
public class QuestionDto {
    @Id
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
