package com.example.ElectionDemo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long questionId;
    private Long userId;
    @Enumerated(EnumType.STRING)
    private com.example.ElectionDemo.dto.Answer answer;
}
