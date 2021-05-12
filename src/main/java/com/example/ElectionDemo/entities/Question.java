package com.example.ElectionDemo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Author: Ulug'bek Ro'zimboyev  <ulugbekrozimboyev@gmail.com>
 * Date: 5/12/2021 1:30 PM
 */
@Entity
@Table(name = "questions")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "questions_id_seq")
    @SequenceGenerator(name = "questions_id_seq")
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

}
