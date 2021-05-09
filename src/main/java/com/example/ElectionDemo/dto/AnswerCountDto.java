package com.example.ElectionDemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnswerCountDto {
    private List<QuestionDto> questions;
    private long count;
}
