package com.example.ElectionDemo.dao;

import com.example.ElectionDemo.dto.CandidateDto;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class CandidateDao {
    public Optional<CandidateDto> findById(Long id) {
        return Optional.empty();
    }

    public static List<CandidateDto> findAll() {
        HashMap<String, String> info = new HashMap<>();
        info.put("age", "21");
        info.put("phone", "12345");
        List<CandidateDto> candidateDtos = Arrays.asList(
                new CandidateDto(1L, "Candidate 1", "chairman at OFB", "about candidate 1", info),
                new CandidateDto(2L, "Candidate 2", "director at 42 school", "about candidate 2", info),
                new CandidateDto(3L, "Candidate 3", "driver at Bank", "about candidate 3", info)
        );
        return candidateDtos;
    }

}
