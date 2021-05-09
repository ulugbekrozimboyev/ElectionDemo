package com.example.ElectionDemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatisticsDto {
    private CandidateDto candidate;
    Map<Answer, AnswerCountDto> statistics;

}
