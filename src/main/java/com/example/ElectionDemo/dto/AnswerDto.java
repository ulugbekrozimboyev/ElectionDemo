package com.example.ElectionDemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnswerDto {
    private Long id;
    private Long questionId;
    private Long userId;
    private Answer answer;
}
