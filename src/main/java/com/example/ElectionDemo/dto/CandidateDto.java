package com.example.ElectionDemo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Map;

/**
 * Author: Ulug'bek Ro'zimboyev  <ulugbekrozimboyev@gmail.com>
 * Date: 5/1/2021 5:30 PM
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class CandidateDto {
    @Id
    private Long id;
    private String fullName;
    private String currentJob;
    private String about;
    @ElementCollection
    private Map<String, String> moreInformation;
}
