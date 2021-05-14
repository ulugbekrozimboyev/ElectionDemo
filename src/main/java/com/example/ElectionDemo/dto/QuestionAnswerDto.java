package com.example.ElectionDemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionAnswerDto {
    private List<QuestionDto> questions;
    private Answer[] answer;
}
