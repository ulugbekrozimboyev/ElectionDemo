package com.example.ElectionDemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AnswerDto {
    @Id
    private Long id;
    private Long questionId;
    private Long userId;
    private Answer answer;
}
