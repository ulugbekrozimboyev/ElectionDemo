package com.example.ElectionDemo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
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
@Table(name = "candidates")
public class CandidateDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "full_name", columnDefinition = "varchar(50) not null default ''")
    private String fullName;
    @Column(name = "current_job")
    private String currentJob;
    private String about;

    @OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.MERGE)
    private List<ItemParam> params;

    @Override
    public String toString() {
        return "CandidateDto{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", currentJob='" + currentJob + '\'' +
                ", about='" + about + '\'' +
                ", params=" + params +
                '}';
    }
}